package com.example.akal.shoppyapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class CheckOutScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


private EditText mStreet;
private EditText mCity;
private EditText mState;
private EditText mPostal;
private Button mSendData;

private Firebase mRef;
        String[] country = {"India", "USA", "China", "Japan", "Other",};

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_screen);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("https://shoppyapp-cae2d.firebaseio.com/delivery/");

        mStreet = (EditText) findViewById(R.id.street);
        mCity = (EditText) findViewById(R.id.city);
        mState = (EditText) findViewById(R.id.state);
        mPostal = (EditText) findViewById(R.id.postal);
        mSendData = (Button) findViewById(R.id.senddata);


        mSendData.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {

        String street = mStreet.getText().toString().trim();
        String city = mCity.getText().toString().trim();
        String state = mState.getText().toString().trim();
        String postal = mPostal.getText().toString().trim();

        DeliveryData dData = new DeliveryData(street, city, state, postal);


        mRef.push().setValue(dData);


        Snackbar.make(
        findViewById(R.id.senddata),
        "Delivery Address Added ",
        Snackbar.LENGTH_SHORT).show();

        }
        });

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        }

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getContext();
        parent.getItemAtPosition(position).toString();

        }

    @Override
public void onNothingSelected(AdapterView<?> parent) {

        }
}
