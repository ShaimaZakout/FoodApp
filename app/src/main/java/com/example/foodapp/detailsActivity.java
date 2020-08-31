package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {
    Intent i;
    TextView priceText, counterID;
    ImageView foodImage;
    Context context = detailsActivity.this;
    LinearLayout bagId;
    private int counter = 0;
    SharedPreferences sp;
    private static final String COUNTER_KEY = "COUNTER";
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        sp = getSharedPreferences(COUNTER_KEY, MODE_PRIVATE);
        editor = sp.edit();
        priceText = findViewById(R.id.price_text);
        foodImage = findViewById(R.id.food_img);
        counterID = findViewById(R.id.counter_id);
        bagId = findViewById(R.id.bag_id);
        i = new Intent();
        priceText.setText(i.getStringExtra("price"));

        foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MainActivity.class));
            }
        });
        counterID.setText(sp.getInt("counter", 0) + "");

        bagId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++counter;
                editor.putInt("counter", counter);
                editor.apply();
                counterID.setText(sp.getInt("counter", 0) + "");

            }
        });



    }


}
