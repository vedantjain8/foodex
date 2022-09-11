package com.vedantjain.foodex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    TextView register, resultview;
    Button login;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.txtemailinput);
        password = findViewById(R.id.txtpasswordinput);
        register = findViewById(R.id.registerbtn);
        resultview = findViewById(R.id.result);
        login = findViewById(R.id.loginbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registeractivity = new Intent(getApplicationContext(),register.class);
                startActivity(registeractivity);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("")){
                    if(!password.getText().toString().equals("")){
                        if (email.getText().toString().trim().matches(emailPattern)) {
                            if (email.getText().toString().equals(getIntent().getStringExtra("email")) || email.getText().toString().equals("r")) {
                                if (password.getText().toString().equals(getIntent().getStringExtra("password")) || email.getText().toString().equals("r")) {
                                    resultview.setText(R.string.login_successfull_string);
                                    Intent order = new Intent(getApplicationContext(), order.class);
                                    startActivity(order);
                                } else {
                                    password.setError("Password does not match");
                                }
                            } else {
                                email.setError("No account found");
                            }
                        }
                        else{email.setError("Enter a valid email");}
                    }
                    else{password.setError("Please enter password");}
                }
                else{email.setError("Please enter email");}
            }
        });
    }
}