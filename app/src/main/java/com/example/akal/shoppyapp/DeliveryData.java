package com.example.akal.shoppyapp;

/**
 * Created by Gursimran on 11-11-2017.
 */

public class DeliveryData {
    private String Street, City, State, Postal, Country;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public DeliveryData(String street, String city, String state, String postal) {
        Street = street;
        City = city;
        State = state;
        Postal = postal;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPostal() {
        return Postal;
    }

    public void setPostal(String postal) {
        Postal = postal;
    }
    @Override
    public String toString() {
        return "DeliveryData{" +
                "Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Postal='" + Postal + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
