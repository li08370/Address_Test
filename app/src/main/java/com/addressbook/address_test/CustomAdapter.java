package com.addressbook.address_test;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Address> {
    private ArrayList<Address> contacts;
    Activity mContext;

    public CustomAdapter(Activity context, ArrayList<Address> contacts) {
        super(context, R.layout.address_list, contacts);
        this.contacts = contacts;
        this.mContext = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= mContext.getLayoutInflater();
        View view = inflater.inflate(R.layout.address_list, null,true);

        TextView firstNameView = (TextView) view.findViewById(R.id.conatct_fName);
        TextView lastNameView = (TextView) view.findViewById(R.id.contact_lName);
        TextView phoneNumberView = (TextView) view.findViewById(R.id.conatct_pNumber);
        TextView addressView = (TextView) view.findViewById(R.id.contact_address);
        Button editButton = (Button) view.findViewById(R.id.editButton);
        //Button removeButton = (Button) view.findViewById(R.id.removeButton);

        final Address contact = contacts.get(position);
        firstNameView.setText(contact.getFirst_name());
        lastNameView.setText(contact.getLast_name());
        phoneNumberView.setText(contact.getPhone_number());
        addressView.setText(contact.getAddress());

        //Button Performance
       /* removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread removeThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        RemoveContactService remove = new RemoveContactService(contact);
                        remove.removeContact();
                    }
                });

                //Replace with better solution later
                try {
                    removeThread.start();
                    removeThread.join();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                mContext.recreate();

            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext.getApplicationContext(), EditContactActivity.class);
                i.putExtra("Contact", contact);
                mContext.startActivity(i);
            }
        });*/
        return view;
    }
}
