package com.addressbook.address_test;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddingActivity extends AppCompatActivity {
    EditText finput, linput, pinput;
    AddAddressService service;
    ArrayList<Address> contacts;
    EditText firstNameInput, lastNameInput, phoneNumberInput, addressInput;
    Button addAccountButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        firstNameInput = (EditText) findViewById(R.id.fNameInput);
        lastNameInput = (EditText) findViewById(R.id.lNameInput);
        phoneNumberInput = (EditText) findViewById(R.id.pNumberInput);
        addressInput = (EditText) findViewById(R.id.addressInput);
       Address tempA = new Address(firstNameInput.getText().toString(),
               lastNameInput.getText().toString(),
               phoneNumberInput.getText().toString(),
               addressInput.getText().toString());

        addAccountButton = (Button) findViewById(R.id.button_first);

       addAccountButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {  service = new AddAddressService(tempA);
             service.onBind(getIntent());
             Thread addContactThread = new Thread(new Runnable() {
                 @RequiresApi(api = Build.VERSION_CODES.N)
                 @Override
                 public void run() {
                     service.addAddress();
                 }
             });

             try {
                 addContactThread.start();
                 addContactThread.join();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             Intent i = new Intent(getApplicationContext(), MainActivity.class);
             startActivity(i);
         }
        });
    }


}

/*
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
                service = new AddAddressService(temp);
                service.onBind(getIntent());
                Thread addContactThread = new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        service.addAddress();
                    }
                });
                NavHostFragment.findNavController(AddingFragment.this)
                        .navigate(R.id.action_AddressFragment_to_AddingFragment);
            }
        });
    }

}*/