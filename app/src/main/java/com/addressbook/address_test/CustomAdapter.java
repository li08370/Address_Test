package com.addressbook.address_test;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.addressbook.address_test.dummy.DummyContent.DummyItem;
import org.w3c.dom.Text;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final List<Address> mValues;

    public CustomAdapter(List<Address> contacts) {
        mValues = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_address, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.contact = mValues.get(position);
        holder.mfName.setText(mValues.get(position).first_name);
        holder.mlName.setText(mValues.get(position).last_name);
        holder.mpNumber.setText(mValues.get(position).phone_number);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
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