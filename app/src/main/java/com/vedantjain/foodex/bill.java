package com.vedantjain.foodex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        TextView txtitem1count, txtitem1price, txtitem2count,txtitem2price,txtitem3count,txtitem3price,txtitem4count,txtitem4price,txtitem5count,txtitem5price,txtitem6count,txtitem6price;
        Integer resultprice;
        TextView totalbill_amt;
        Float finalbill_amt;
        Button confirm_bill;

        confirm_bill=findViewById(R.id.confirm_bill);
//=========================================================
        txtitem1count = findViewById(R.id.item1count);
        txtitem1price = findViewById(R.id.item1amount);

        txtitem2count = findViewById(R.id.item2count);
        txtitem2price = findViewById(R.id.item2amount);

        txtitem3count = findViewById(R.id.item3count);
        txtitem3price = findViewById(R.id.item3amount);

        txtitem4count = findViewById(R.id.item4count);
        txtitem4price = findViewById(R.id.item4amount);

        txtitem5count = findViewById(R.id.item5count);
        txtitem5price = findViewById(R.id.item5amount);

        txtitem6count = findViewById(R.id.item6count);
        txtitem6price = findViewById(R.id.item6amount);

        totalbill_amt = findViewById(R.id.totalamount);
//=========================================================
        txtitem1count.setText(getIntent().getStringExtra("item1count") + " * " +getIntent().getStringExtra("item1name"));
        resultprice =  Integer.parseInt(getIntent().getStringExtra("item1count")) * Integer.parseInt(getIntent().getStringExtra("item1price"));
        txtitem1price.setText(Float.toString(resultprice));

        txtitem2count.setText(getIntent().getStringExtra("item2count") + " * " +getIntent().getStringExtra("item2name"));
        resultprice =  Integer.parseInt(getIntent().getStringExtra("item2count")) * Integer.parseInt(getIntent().getStringExtra("item2price"));
        txtitem2price.setText(Float.toString(resultprice));

        txtitem3count.setText(getIntent().getStringExtra("item3count") + " * " +getIntent().getStringExtra("item3name"));
        resultprice =  Integer.parseInt(getIntent().getStringExtra("item3count")) * Integer.parseInt(getIntent().getStringExtra("item3price"));
        txtitem3price.setText(Float.toString(resultprice));

        txtitem4count.setText(getIntent().getStringExtra("item4count") + " * " +getIntent().getStringExtra("item4name"));
        resultprice =  Integer.parseInt(getIntent().getStringExtra("item4count")) * Integer.parseInt(getIntent().getStringExtra("item4price"));
        txtitem4price.setText(Float.toString(resultprice));

        txtitem5count.setText(getIntent().getStringExtra("item5count") + " * " +getIntent().getStringExtra("item5name"));
        resultprice =  Integer.parseInt(getIntent().getStringExtra("item5count")) * Integer.parseInt(getIntent().getStringExtra("item5price"));
        txtitem5price.setText(Float.toString(resultprice));

        txtitem6count.setText(getIntent().getStringExtra("item6count") + " * " +getIntent().getStringExtra("item6name"));
        resultprice =  Integer.parseInt(getIntent().getStringExtra("item6count")) * Integer.parseInt(getIntent().getStringExtra("item6price"));
        txtitem6price.setText(Float.toString(resultprice));
//=========================================================
        finalbill_amt = Float.parseFloat(txtitem1price.getText().toString())+Float.parseFloat(txtitem2price.getText().toString())+Float.parseFloat(txtitem3price.getText().toString())+Float.parseFloat(txtitem4price.getText().toString())+Float.parseFloat(txtitem5price.getText().toString())+Float.parseFloat(txtitem6price.getText().toString());
        totalbill_amt.setText(Float.toString(finalbill_amt));

        confirm_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm = new Intent(getApplicationContext(),orderplaced.class);
                confirm.putExtra("finalbillamount",Float.toString(finalbill_amt));
                startActivity(confirm);
            }
        });
    }
}