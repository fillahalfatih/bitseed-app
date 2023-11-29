package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LearnHias extends AppCompatActivity {

    LinearLayout to_lidah_mertua, to_anggrek, to_begonia;
    ImageView to_learn, to_home, to_shop, to_profile;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_hias);

        to_learn = findViewById(R.id.to_learn);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, Learn.class);
                startActivity(i);
            }
        });

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, HomePage.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, Shop.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, Profile.class);
                startActivity(i);
            }
        });

        to_lidah_mertua = findViewById(R.id.cardLidahMertua);
        to_lidah_mertua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, LidahMertua.class);
                startActivity(i);
            }
        });

        to_anggrek = findViewById(R.id.cardAnggrek);
        to_anggrek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, Anggrek.class);
                startActivity(i);
            }
        });

        to_begonia = findViewById(R.id.cardBegonia);
        to_begonia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnHias.this, Begonia.class);
                startActivity(i);
            }
        });
    }
}