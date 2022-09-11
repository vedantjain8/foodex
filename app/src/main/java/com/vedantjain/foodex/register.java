package com.vedantjain.foodex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    String email,pass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register;
        EditText registeremail, registerpass,confirmregisterpass;
        TextView loginbtn;

        register= findViewById(R.id.register);
        registeremail = findViewById(R.id.registertxtemailinput);
        registerpass = findViewById(R.id.registertxtpasswordinput);
        confirmregisterpass = findViewById(R.id.confirmregistertxtpasswordinput);
        loginbtn = findViewById(R.id.loginbtn);

        Intent login = new Intent(getApplicationContext(),MainActivity.class);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registeremail.getText().toString().trim().matches(emailPattern)) {
                    if (registerpass.getText().toString().length()>8) {
                        if (registerpass.getText().toString().equals(confirmregisterpass.getText().toString())) {
                            email = registeremail.getText().toString();
                            pass = registerpass.getText().toString();

                            login.putExtra("email", email);
                            login.putExtra("password", pass);
                            startActivity(login);
                        } else {
                            Toast.makeText(register.this, "Password incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{Toast.makeText(register.this,"Enter a strong password",Toast.LENGTH_SHORT).show();}
                }
                else{
                    Toast.makeText(register.this,"Enter a valid email", Toast.LENGTH_SHORT).show();
                }
            }
            });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);}});
    }
}