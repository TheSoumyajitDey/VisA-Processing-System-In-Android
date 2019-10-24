package com.example.visa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class SignUp_Page extends AppCompatActivity {

    protected Button submitButtonPressed;

    protected String fullName;
    EditText getFullName;

    protected String fullAddress;
    EditText getFullAddres;

    protected String phoneNumber;
    EditText getPhoneNumber;

    protected String gender;
    EditText getGender;

    protected String emailIdentification;
    EditText getEmailID;

    protected String country;
    EditText getCountry;

    protected String passportNumber;
    EditText getPassportNumber;

    protected String dateofissue;
    EditText getdateofissue;

    protected String validupto;
    EditText getvalidupto;

    protected String dateofbirth;
    EditText getdateofbirth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__page);

        getSupportActionBar().setTitle("Sign Up");

        getFullName = (EditText) findViewById(R.id.myname);
        getFullAddres = (EditText) findViewById(R.id.fulladdress);
        getCountry = (EditText) findViewById(R.id.country);
        getEmailID = (EditText) findViewById(R.id.emailid);
        getPassportNumber = (EditText) findViewById(R.id.passportnumber);
        getPhoneNumber = (EditText)findViewById(R.id.phonenumber);
        getdateofbirth = (EditText)findViewById(R.id.dateofbirth);
        getdateofissue = (EditText)findViewById(R.id.passportdateofissue);
        getvalidupto = (EditText)findViewById(R.id.passportvalidupto);
        getGender = (EditText)findViewById(R.id.gender);





        submitButtonPressed = (Button)findViewById(R.id.submitbutton);
        submitButtonPressed.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = getFullName.getText().toString();
                fullAddress = getFullAddres.getText().toString();
                country = getCountry.getText().toString();
                emailIdentification = getEmailID.getText().toString();
                passportNumber = getPassportNumber.getText().toString();
                phoneNumber = getPhoneNumber.getText().toString();
                gender = getGender.getText().toString();
                dateofbirth = getdateofbirth.getText().toString();
                dateofissue = getdateofissue.getText().toString();
                validupto = getvalidupto.getText().toString();



                if(fullName.equals("") && fullAddress .equals("") && country.equals("") && emailIdentification.equals("") && passportNumber.equals("") && phoneNumber.equals("") && gender.equals("") && dateofissue.equals("") && dateofbirth.equals("")&& validupto.equals("")){
                    Toast.makeText(getApplicationContext(), "Text Fields are empty please fill! to procced further", LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),         "All Value Correct! Form Submitted"
                            , LENGTH_SHORT).show();

                    openConformationPage();

                }

            }
        });
    }


    public void openConformationPage(){
        Intent intent = new Intent(SignUp_Page.this,FileSentConformed.class);
        intent.putExtra("fullname",fullName);
        intent.putExtra("fullAddress",fullAddress);
        intent.putExtra("country",country);
        intent.putExtra("emailIdentification",emailIdentification);
        intent.putExtra("passportNumber",passportNumber);
        intent.putExtra("phoneNumber",phoneNumber);
        intent.putExtra("gender",gender);
        intent.putExtra("dateofbirth",dateofbirth);
        intent.putExtra("dateofissue",dateofissue);
        intent.putExtra("validupto",validupto);
        startActivity(intent);
    }
}
