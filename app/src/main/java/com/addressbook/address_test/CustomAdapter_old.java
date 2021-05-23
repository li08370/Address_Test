package com.addressbook.address_test;

import android.app.Activity;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class CustomAdapter_old extends RecyclerView.Adapter<CustomAdapter_old.ViewHolder> {

    Activity mContext;
    private List<Address> contacts;

    public CustomAdapter_old(List<Address> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.address_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.contact = contacts.get(position);
        holder.mfName.setText(contacts.get(position).first_name);
        holder.mlName.setText(contacts.get(position).last_name);
        holder.mpNumber.setText(contacts.get(position).phone_number);
        holder.maddress.setText(contacts.get(position).address);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mfName;
        public final TextView mlName;
        public final TextView mpNumber;
        public TextView maddress;
        public Button mEdit;
        public Button mDelete;
        public Address contact;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mfName = (TextView) view.findViewById(R.id.conatct_fName);
            mlName = (TextView) view.findViewById(R.id.contact_lName);
            mpNumber = (TextView) view.findViewById(R.id.conatct_pNumber);
            maddress = (TextView) view.findViewById(R.id.contact_address);
            /*mEdit = (Button) view.findViewById(R.id.editButton);
            mDelete = (Button) view.findViewById(R.id.deleteButton);*/

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mpNumber.getText() + "'";
        }
    }
}
