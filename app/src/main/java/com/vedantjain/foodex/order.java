package com.vedantjain.foodex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity {

    float total=0;
    int item1count=0,item2count=0,item3count=0,item4count=0,item5count=0,item6count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Button addtocart1,addtocart2,addtocart3,addtocart4,addtocart5,addtocart6;
        TextView item1price,item2price,item3price,item4price,item5price,item6price,final_amt_btn;
        TextView item1name, item2name,item3name,item4name,item5name,item6name;
        CardView total_amount_cardview;

        addtocart1 = findViewById(R.id.order_box_1_button);
        addtocart2 = findViewById(R.id.order_box_2_button);
        addtocart3 = findViewById(R.id.order_box_3_button);
        addtocart4 = findViewById(R.id.order_box_4_button);
        addtocart5 = findViewById(R.id.order_box_5_button);
        addtocart6 = findViewById(R.id.order_box_6_button);

        total_amount_cardview = findViewById(R.id.total_amount_cardview);
        final_amt_btn = findViewById(R.id.total_amount_button);

        item1price = findViewById(R.id.order_box_1_price);
        item2price = findViewById(R.id.order_box_2_price);
        item3price = findViewById(R.id.order_box_3_price);
        item4price = findViewById(R.id.order_box_4_price);
        item5price = findViewById(R.id.order_box_5_price);
        item6price = findViewById(R.id.order_box_6_price);

        item1name = findViewById(R.id.order_box_1_head);
        item2name = findViewById(R.id.order_box_2_head);
        item3name = findViewById(R.id.order_box_3_head);
        item4name = findViewById(R.id.order_box_4_head);
        item5name = findViewById(R.id.order_box_5_head);
        item6name = findViewById(R.id.order_box_6_head);

        addtocart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += Integer.parseInt(item1price.getHint().toString());
                final_amt_btn.setText(Float.toString(total));
                item1count +=1;
            }
        });
        addtocart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += Integer.parseInt(item2price.getHint().toString());
                final_amt_btn.setText(Float.toString(total));
                item2count +=1;
            }
        });
        addtocart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += Integer.parseInt(item3price.getHint().toString());
                final_amt_btn.setText(Float.toString(total));
                item3count +=1;
            }
        });
        addtocart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += Integer.parseInt(item4price.getHint().toString());
                final_amt_btn.setText(Float.toString(total));
                item4count +=1;
            }
        });
        addtocart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += Integer.parseInt(item5price.getHint().toString());
                final_amt_btn.setText(Float.toString(total));
                item5count +=1;
            }
        });
        addtocart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += Integer.parseInt(item6price.getHint().toString());
                final_amt_btn.setText(Float.toString(total));
                item6count +=1;
            }
        });

        total_amount_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (final_amt_btn.getText().toString().equals("0")) {
                    Toast.makeText(order.this, "Please add some item to cart!", Toast.LENGTH_SHORT).show();                }
                else {
                    Intent bill = new Intent(getApplicationContext(), bill.class);
                    bill.putExtra("item1count",Integer.toString(item1count));
                    bill.putExtra("item1name", item1name.getText().toString());
                    bill.putExtra("item1price", item1price.getHint().toString());

                    bill.putExtra("item2count",Integer.toString(item2count));
                    bill.putExtra("item2name", item2name.getText().toString());
                    bill.putExtra("item2price", item2price.getHint().toString());

                    bill.putExtra("item3count",Integer.toString(item3count));
                    bill.putExtra("item3name", item3name.getText().toString());
                    bill.putExtra("item3price", item3price.getHint().toString());

                    bill.putExtra("item4count",Integer.toString(item4count));
                    bill.putExtra("item4name", item4name.getText().toString());
                    bill.putExtra("item4price", item4price.getHint().toString());

                    bill.putExtra("item5count",Integer.toString(item5count));
                    bill.putExtra("item5name", item5name.getText().toString());
                    bill.putExtra("item5price", item5price.getHint().toString());

                    bill.putExtra("item6count",Integer.toString(item6count));
                    bill.putExtra("item6name", item6name.getText().toString());
                    bill.putExtra("item6price", item6price.getHint().toString());
                    startActivity(bill);
                }
            }
        });

    }
}