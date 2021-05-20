package com.addressbook.address_test;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class AddingFragment extends Fragment {
EditText finput, linput, pinput;
AddAddressService service;

boolean isBound;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        finput = view.findViewById(R.id.fNameInput);
        linput = view.findViewById(R.id.lNameInput);
        pinput = view.findViewById(R.id.pNumberInput);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Address temp = new Address(finput.getText().toString(), linput.getText().toString(), pinput.getText().toString());
                Intent intent = getActivity().getIntent();
                service = new AddAddressService(temp);
                service.onBind(intent);
                Thread addContactThread = new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        service.addAddress();
                    }
                });
                NavHostFragment.findNavController(AddingFragment.this)
                        .navigate(R.id.action_FirstFragment_to_AddressFragment);
            }
        });
    }

}