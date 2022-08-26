package com.vedantjain.foodex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class orderplaced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderplaced);

        TextView totalamount_confirm;
        Button btn_go_home;

        totalamount_confirm = findViewById(R.id.totalamount_confirm);
        totalamount_confirm.setText(getIntent().getStringExtra("finalbillamount"));

        btn_go_home = findViewById(R.id.btn_home);
        btn_go_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome = new Intent(getApplicationContext(), order.class);
                startActivity(gohome);
            }
        });
    }
}