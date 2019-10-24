package com.example.visa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (Button) findViewById(R.id.button);
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckingPage();
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });
    }


    public void openSignUpPage(){
        Intent intent = new Intent(this,SignUp_Page.class);
        startActivity(intent);

    }

    public void openCheckingPage(){
        Intent intent2 = new Intent(this,CheckingPage.class);
        startActivity(intent2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu,menu);


        return true;
    }
}
