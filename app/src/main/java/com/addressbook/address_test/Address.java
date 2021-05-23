package com.addressbook.address_test;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class Address implements Comparable<Address>, Serializable {
    String first_name, last_name, phone_number, address;

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        String s = "First name: " + first_name + ", ";
        s += "Last name: " + last_name + ", ";
        s += "\nPhone number: " + phone_number + ",";
        s += "\nAddress: " + address;
        return s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address otherAddress = (Address) obj;
            if (this.getFirst_name().equalsIgnoreCase(otherAddress.getFirst_name()) &&
                    this.getLast_name().equalsIgnoreCase(otherAddress.getLast_name()) &&
                    this.getPhone_number().equalsIgnoreCase(otherAddress.getPhone_number()) &&
                    this.getAddress().equalsIgnoreCase(otherAddress.getAddress())){
                return true;
            }
        }
        return false;
    }

    public int compareTo(Address a){
        return (first_name.compareTo(a.getFirst_name()));
    }
    Address(String first_name, String last_name, String phone_number){
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = "empty";
    }

    Address(String first_name, String last_name, String phone_number, String address){
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
    }
}