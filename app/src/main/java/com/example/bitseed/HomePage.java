package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomePage extends AppCompatActivity {

    LinearLayout to_buah, to_hias, to_sayur, to_organik, to_anorganik;
    ImageView to_learn, to_shop, to_profile, to_favorit, to_komunitas, to_chatbot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        to_learn = findViewById(R.id.learn_nav);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, Learn.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, Shop.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, Profile.class);
                startActivity(i);
            }
        });

        to_buah = findViewById(R.id.card_buah);
        to_buah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, LearnBuah.class);
                startActivity(i);
            }
        });

        to_hias = findViewById(R.id.card_hias);
        to_hias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, LearnHias.class);
                startActivity(i);
            }
        });

        to_sayur = findViewById(R.id.card_sayur);
        to_sayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, LearnSayur.class);
                startActivity(i);
            }
        });

        to_organik = findViewById(R.id.cardOrganik);
        to_organik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, LearnOrganik.class);
                startActivity(i);
            }
        });

        to_anorganik = findViewById(R.id.cardAnorganik);
        to_anorganik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, LearnOrganik.class);
                startActivity(i);
            }
        });

        to_favorit = findViewById(R.id.favorit);
        to_favorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, Favorit.class);
                startActivity(i);
            }
        });

        to_komunitas = findViewById(R.id.komunitas);
        to_komunitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, Komunitas.class);
                startActivity(i);
            }
        });

        to_chatbot = findViewById(R.id.chatbot);
        to_chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(HomePage.this, Chatbot.class);
                startActivity(i);
            }
        });
    }
}