package com.addressbook.address_test;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class AddressFragment extends Fragment {
   private ArrayList<Address> contacts;
   Activity mContext;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AddressFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AddressFragment newInstance(int columnCount) {
        AddressFragment fragment = new AddressFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final GetContactService getContactsService = new GetContactService();
        Thread getContactsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                contacts = getContactsService.getContactsFromDatabase();
            }
        });
        try {
            getContactsThread.start();
            getContactsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_list, container, false);
       // AddAddressService.addAddress(getArguments().getParcelable("Address"));
        // Set the adapter
        mContext = (Activity) container.getContext();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new CustomAdapter(contacts));
        }
        return view;
    }
}