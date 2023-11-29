package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LearnBuah extends AppCompatActivity {

    LinearLayout to_mangga, to_apel, to_pisang, to_pepaya, to_durian;
    ImageView to_learn, to_home, to_shop, to_profile;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_buah);

        to_learn = findViewById(R.id.to_learn);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, Learn.class);
                startActivity(i);
            }
        });

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, HomePage.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, Shop.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, Profile.class);
                startActivity(i);
            }
        });

        to_mangga = findViewById(R.id.cardMangga);
        to_mangga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, ManggaKio.class);
                startActivity(i);
            }
        });

        to_apel = findViewById(R.id.cardApel);
        to_apel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, ApelFuji.class);
                startActivity(i);
            }
        });

        to_pisang = findViewById(R.id.cardPisang);
        to_pisang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, Pisang.class);
                startActivity(i);
            }
        });

        to_pepaya = findViewById(R.id.cardPepaya);
        to_pepaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, Pepaya.class);
                startActivity(i);
            }
        });

        to_durian = findViewById(R.id.cardDurian);
        to_durian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnBuah.this, Durian.class);
                startActivity(i);
            }
        });
    }
}