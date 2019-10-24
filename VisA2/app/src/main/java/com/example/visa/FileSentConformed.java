package com.example.visa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FileSentConformed extends AppCompatActivity {

    Button homepage;
    TextView keyforchecking;
    DatabaseReference reff;

    VIsaInformation visaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_sent_conformed);


        getSupportActionBar().setTitle("Application Review");

        homepage = (Button) findViewById(R.id.homebutton);
        keyforchecking = (TextView)findViewById(R.id.textView3);

//        Intent intent = new Intent(SignUp_Page.this,FileSentConformed.class);
//        intent.putExtra("fullname",fullName);
//        intent.putExtra("fullAddress",fullAddress);
//        intent.putExtra("country",country);
//        intent.putExtra("emailIdentification",emailIdentification);
//        intent.putExtra("passportNumber",passportNumber);
//        intent.putExtra("phoneNumber",phoneNumber);
//        intent.putExtra("gender",gender);
//        intent.putExtra("dateofbirth",dateofbirth);
//        intent.putExtra("dateofissue",dateofissue);
//        intent.putExtra("validupto",validupto);
//        startActivity(intent);




           String fullname = getIntent().getStringExtra("fullname");
           String fullAddress = getIntent().getStringExtra("fullAddress");
           String country = getIntent().getStringExtra("country");
           String emailIdentification = getIntent().getStringExtra("emailIdentification");
           String passportNumber = getIntent().getStringExtra("passportNumber");
           String phoneNumber = getIntent().getStringExtra("phoneNumber");
           String gender = getIntent().getStringExtra("gender");
           String dateofbirth = getIntent().getStringExtra("dateofbirth");
           String dateofissue = getIntent().getStringExtra("dateofissue");
           String validupto = getIntent().getStringExtra("validupto");





        reff = FirebaseDatabase.getInstance().getReference().child("VisaData");



        visaData = new VIsaInformation(fullname,fullAddress,country,emailIdentification,passportNumber,  phoneNumber, gender,dateofbirth, dateofissue, validupto);










        String catalyst = getAlphaNumericString(10);
        final String pushCataluyst = catalyst;
        catalyst = catalyst + " : Search Token Key";
        keyforchecking.setText(catalyst);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homepagefunc();

                visaData.getFullname();
                visaData.getCountry();
                visaData.getDateofbirth();
                visaData.getEmailIdentification();
                visaData.getGender();
                visaData.getPhoneNumber();
                visaData.getValidupto();
                visaData.getDateofissue();
                visaData.getPassportNumber();
                visaData.getFullAddress();
                visaData.getPass();



                reff.child(pushCataluyst).setValue(visaData);


            }
        });


    }

    public void homepagefunc() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


}
