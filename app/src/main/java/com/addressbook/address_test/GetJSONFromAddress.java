package com.addressbook.address_test;
public class GetJSONFromAddress {

    protected static String getJSONFromAddress(Address address) {
        return "{\"firstname\": \"" + address.getFirst_name() + "\", " +
                "\"lastname\": \"" + address.getLast_name() + "\", " +
                "\"phonenumber\": \"" + address.getPhone_number() + "\"}" ;
                //+"\"address\": \"" + address.get() + "\", " +
               // "\"code\": \"" + address.getID() + "\"}";
    }
}