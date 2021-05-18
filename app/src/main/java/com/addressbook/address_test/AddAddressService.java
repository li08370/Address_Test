package com.addressbook.address_test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.RequiresApi;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;

    public class AddAddressService extends Service {

        static ArrayList<Address> storage  = new ArrayList<>();
        private final IBinder mBinder = new AddressBinder();
        Address address;

        public class AddressBinder extends Binder {
            AddAddressService getService() {
                return AddAddressService.this;
            }
        }
        public AddAddressService(Address a) {
            this.address = a;
        }

        @Override
        public IBinder onBind(Intent intent) {
            return mBinder;
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void addAddress() {

            Client client = Client.create();

            WebResource webResource = client.resource(Domain.getDomain() + "/rest/addContact");

            String input = GetJSONFromAddress.getJSONFromAddress(address);

            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, input);

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            //storage.add(a);
            //storage.sort(Address::compareTo);
        }

        public static Address getAddress(int position){
            return storage.get(position);
        }

        public static ArrayList<Address> getStorage(){
            return storage;
        }
}
