package com.example.visa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatusDashboard extends AppCompatActivity {

    String tokenValue;

    String name, address, gender, emailid, country, phonenumber, passportnumber, dob, doi, validupto, passu;
    TextView genname, genaddress, gengender, genemailid, gencountry, genphonenumber, genpassportnumber, gendob, gendoi, genvalidupto, passStatus;
    DatabaseReference reff1;

    Button press;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_dashboard);

        getSupportActionBar().setTitle("Applied Visa Dashboard Status");


        tokenValue = getIntent().getStringExtra("1q2w3r");

        genname = (TextView) findViewById(R.id.myname);

        genaddress = (TextView) findViewById(R.id.myaddess);
        gengender = (TextView) findViewById(R.id.mygender);
        genemailid = (TextView) findViewById(R.id.myemail);
        gencountry = (TextView) findViewById(R.id.mycountry);
        genphonenumber = (TextView) findViewById(R.id.myaphonenumber);
        genpassportnumber = (TextView) findViewById(R.id.mypassport);
        gendob = (TextView) findViewById(R.id.mydateOfbirth);
        gendoi = (TextView) findViewById(R.id.dateofIssue);
        genvalidupto = (TextView) findViewById(R.id.validupto);
        passStatus = (TextView) findViewById(R.id.passStatus);


        press = (Button) findViewById(R.id.reloadbutton);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homepagefunc();


            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();

        reff1 = FirebaseDatabase.getInstance().getReference().child("VisaData").child(tokenValue);
        reff1.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                name = dataSnapshot.child("fullname").getValue().toString();
                address = dataSnapshot.child("fullAddress").getValue().toString();
                country = dataSnapshot.child("country").getValue().toString();
                emailid = dataSnapshot.child("emailIdentification").getValue().toString();
                passportnumber = dataSnapshot.child("passportNumber").getValue().toString();
                gender = dataSnapshot.child("gender").getValue().toString();
                dob = dataSnapshot.child("dateofbirth").getValue().toString();
                doi = dataSnapshot.child("dateofissue").getValue().toString();
                validupto = dataSnapshot.child("validupto").getValue().toString();
                passu = dataSnapshot.child("pass").getValue().toString();
                phonenumber = dataSnapshot.child("phoneNumber").getValue().toString();





                genname.setText(" Name: " + name.trim());
                genaddress.setText(" Address: " +address.trim());
                gengender.setText(" Gender: " +gender.trim());
                genemailid.setText(" EmailID: " +emailid.trim());
                gencountry.setText(" Country: " +country.trim());
                genphonenumber.setText(" Phone Number: " +phonenumber.trim());
                genpassportnumber.setText(" Passport Number: " +passportnumber.trim());
                gendob.setText(" Date Of Birth: " +dob.trim());
                gendoi.setText(" Date Of Issue: " +doi.trim());
                genvalidupto.setText(" Valid upto: " +validupto.trim());


                if (passu.equals("maybe")){
                    passStatus.setText(" Passport Status: Visa Application on Process");
                    passStatus.setTextColor(Color.YELLOW);
                }
                else if (passu.equals(("yes"))){
                    passStatus.setText(" Passport Status: Visa Accepted");
                    passStatus.setTextColor(Color.GREEN);

                }else {
                    passStatus.setText(" Passport Status: Visa Rejected");
                    passStatus.setTextColor(Color.RED);

                }


//
//


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });





    }

    public void homepagefunc() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

