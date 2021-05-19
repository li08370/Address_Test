package com.addressbook.address_test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;

import java.util.ArrayList;

    public class DeleteAddressService extends Service {
        static ArrayList<Address> rem = AddAddressService.getStorage();
        private final IBinder mBinder = new AddressBinder();

        public class AddressBinder extends Binder {
            DeleteAddressService getService(){
                return DeleteAddressService.this;
            }
        }
        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return mBinder;
        }
        public static void removeAddress(int index){
            rem.remove(index);
        }
    }

