package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Learn extends AppCompatActivity {

    LinearLayout to_buah, to_sayur, to_hias, to_organik, to_anorganik;
    ImageView back_to_homepage, to_home, to_shop, to_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        back_to_homepage = findViewById(R.id.back_nav);
        back_to_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, HomePage.class);
                startActivity(i);
            }
        });

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, HomePage.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, Shop.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, Profile.class);
                startActivity(i);
            }
        });

        to_buah = findViewById(R.id.card_buah);
        to_buah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, LearnBuah.class);
                startActivity(i);
            }
        });

        to_sayur = findViewById(R.id.card_sayur);
        to_sayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, LearnSayur.class);
                startActivity(i);
            }
        });

        to_hias = findViewById(R.id.card_hias);
        to_hias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, LearnHias.class);
                startActivity(i);
            }
        });

        to_organik = findViewById(R.id.card_pupuk_organik);
        to_organik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, LearnOrganik.class);
                startActivity(i);
            }
        });

        to_anorganik = findViewById(R.id.card_pupuk_anorganik);
        to_anorganik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Learn.this, LearnAnorganik.class);
                startActivity(i);
            }
        });
    }
}