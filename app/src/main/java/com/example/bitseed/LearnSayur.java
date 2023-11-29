package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LearnSayur extends AppCompatActivity {

    LinearLayout to_tomat, to_pakcoy, to_kentang, to_wortel;
    ImageView to_learn, to_home, to_shop, to_profile;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_sayur);

        to_learn = findViewById(R.id.to_learn);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Learn.class);
                startActivity(i);
            }
        });

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, HomePage.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Shop.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Profile.class);
                startActivity(i);
            }
        });

        to_tomat = findViewById(R.id.cardTomat);
        to_tomat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Tomat.class);
                startActivity(i);
            }
        });

        to_pakcoy = findViewById(R.id.cardPakcoy);
        to_pakcoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Pakcoy.class);
                startActivity(i);
            }
        });

        to_kentang = findViewById(R.id.cardKentang);
        to_kentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Kentang.class);
                startActivity(i);
            }
        });

        to_wortel = findViewById(R.id.cardWortel);
        to_wortel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(LearnSayur.this, Wortel.class);
                startActivity(i);
            }
        });
    }
}