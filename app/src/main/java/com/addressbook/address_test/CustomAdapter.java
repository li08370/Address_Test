package com.addressbook.address_test;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Address> contacts;
    public CustomAdapter(List<Address> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_address_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.contact = contacts.get(position);
        holder.mfName.setText(contacts.get(position).first_name);
        holder.mlName.setText(contacts.get(position).last_name);
        holder.mpNumber.setText(contacts.get(position).phone_number);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mfName;
        public final TextView mlName;
        public final TextView mpNumber;
        public Address contact;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mfName = (TextView) view.findViewById(R.id.contact_fName);
            mlName = (TextView) view.findViewById(R.id.contact_lName);
            mpNumber = (TextView) view.findViewById(R.id.contact_pNumber);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mpNumber.getText() + "'";
        }
    }
}