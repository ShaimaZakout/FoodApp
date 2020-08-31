package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Context context=MainActivity.this;
 ViewPager sliderCards;
 SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderCards=findViewById(R.id.slider_cards);
        sliderAdapter=new SliderAdapter(context);
        sliderCards.setAdapter(sliderAdapter);



    }
}
