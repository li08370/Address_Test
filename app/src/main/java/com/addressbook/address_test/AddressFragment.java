package com.addressbook.address_test;
/*
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

public class AddressFragment extends Fragment {
   private ArrayList<Address> contacts = new ArrayList<>();
   Activity mContext;
   GetContactService con;

   Button addButton;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

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
        con = new GetContactService();
        Thread getContactsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                contacts = con.getContactsFromDatabase();
            }
        });

        try {
            getContactsThread.start();
            getContactsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Collections.sort(contacts);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.address_list, container, false);
       // AddAddressService.addAddress(getArguments().getParcelable("Address"));
        // Set the adapter
        mContext = (Activity) container.getContext();
        contacts.add(new Address("Test", "Contact", "is", "working"));
        CustomAdapter_old ca = new CustomAdapter_old(contacts);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(ca);
        }
        return view;
    }
}*/