package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {
    Context context;
    ArrayList<String> titleText = new ArrayList<>();
    ArrayList<String> priceText = new ArrayList<>();
    ArrayList<Integer> imgs = new ArrayList<>();
    ImageView image;
    TextView title, price;


    public SliderAdapter(Context context) {
        this.context = context;
        titleText.add("vegan salad bowl");
        titleText.add("vegan salad bowl");
        titleText.add("vegan salad bowl");
        titleText.add("vegan salad bowl");
        titleText.add("vegan salad bowl");
        priceText.add("20$");
        priceText.add("40$");
        priceText.add("60$");
        priceText.add("40$");
        priceText.add("60$");
        imgs.add(R.drawable.image_1);
        imgs.add(R.drawable.popular1);
        imgs.add(R.drawable.recommended1);
        imgs.add(R.drawable.image_2);
        imgs.add(R.drawable.image_1);
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final int currentPostion = position;
        View view = LayoutInflater.from(context).inflate(R.layout.custom_slider_card, null, false);
        price = view.findViewById(R.id.price_text);
        title = view.findViewById(R.id.title_card_text);
        image = view.findViewById(R.id.food_img);
        price.setText(priceText.get(position));
        title.setText(titleText.get(position));
        image.setImageResource(imgs.get(position));
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, detailsActivity.class);
                i.putExtra("price", price.getText().toString());
                context.startActivity(i);

            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
