package com.example.velometricdemoproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;


    private EditText inputPassword;
   private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputPassword = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        btnLogin = (Button) findViewById(R.id.btnLogin);


    }

    public void Login(View view){
        switch (view.getId()){

            case R.id.btnLogin:

                Intent intent = new Intent(LoginActivity.this,
                        MainActivity.class);

                startActivity(intent);
                //CheckLoginLocal();
                break;
        }

    }

    private void CheckLoginLocal() {



        String stEmail= email.getText().toString();
           String Password= inputPassword.getText().toString();

        if (stEmail.isEmpty() || Password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please input email and password", Toast.LENGTH_LONG).show();

        }else {
            if (Password.equalsIgnoreCase("12345") || stEmail.equalsIgnoreCase("abc@gmail.com")) {

                Toast.makeText(getApplicationContext(),
                        "Login Successful", Toast.LENGTH_LONG)
                        .show();
                Intent intent = new Intent(LoginActivity.this,
                        MainActivity.class);

                startActivity(intent);
                finish();
            } else {
                // Prompt user to enter credentials
                Toast.makeText(getApplicationContext(),
                        "Please enter correct credentials!", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}

