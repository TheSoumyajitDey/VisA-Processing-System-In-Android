package com.example.visa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CheckingPage extends AppCompatActivity {

    Button seachButton;
    EditText seachToken;
    String tokenValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_page);

        seachToken = (EditText)findViewById(R.id.searchToken);


        seachButton = (Button) findViewById(R.id.button10);
        seachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tokenValue = seachToken.getText().toString();

                if(tokenValue.equals("")){



                    Toast.makeText(getApplicationContext(),"Token Search Can not be empty",Toast.LENGTH_LONG).show();


                }else {
                    Toast.makeText(getApplicationContext(),"Token Accepted",Toast.LENGTH_LONG).show();
                    statusDashboardPage();

                }
            }
        });




    }

    public void statusDashboardPage(){
        Intent i = new Intent(CheckingPage.this,StatusDashboard.class);
        i.putExtra("1q2w3r",tokenValue);
        startActivity(i);
    }



}
