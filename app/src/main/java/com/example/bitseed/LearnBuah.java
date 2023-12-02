package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LearnBuah extends AppCompatActivity {

    LinearLayout to_mangga, to_apel, to_pisang, to_pepaya, to_durian;
    ImageView to_learn, to_home, to_shop, to_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_buah);

        ImageView favorit1 = findViewById(R.id.favorit1);
        favorit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan Toast
                Toast.makeText(LearnBuah.this, "Item disimpan ke favorit", Toast.LENGTH_SHORT).show();

                // Menggunakan Handler untuk menunda intent selama 1 detik
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Menggunakan Intent untuk berpindah ke Favorit Activity dan mengirimkan informasi bahwa card1 harus ditampilkan
                        Intent intent = new Intent(LearnBuah.this, Favorit.class);
                        intent.putExtra("showCard", 1); // Mengirimkan informasi bahwa card1 harus ditampilkan
                        startActivity(intent);
                    }
                }, 1250); // Menunda selama 1 detik (1000 milidetik)
            }
        });

        ImageView favorit2 = findViewById(R.id.favorit2);
        favorit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan Toast
                Toast.makeText(LearnBuah.this, "Item disimpan ke favorit", Toast.LENGTH_SHORT).show();

                // Menggunakan Handler untuk menunda intent selama 1 detik
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Menggunakan Intent untuk berpindah ke Favorit Activity dan mengirimkan informasi bahwa card2 harus ditampilkan
                        Intent intent = new Intent(LearnBuah.this, Favorit.class);
                        intent.putExtra("showCard", 2); // Mengirimkan informasi bahwa card2 harus ditampilkan
                        startActivity(intent);
                    }
                }, 1250); // Menunda selama 1 detik (1000 milidetik)
            }
        });

        ImageView favorit3 = findViewById(R.id.favorit3);
        favorit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan Toast
                Toast.makeText(LearnBuah.this, "Item disimpan ke favorit", Toast.LENGTH_SHORT).show();

                // Menggunakan Handler untuk menunda intent selama 1 detik
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Menggunakan Intent untuk berpindah ke Favorit Activity dan mengirimkan informasi bahwa card2 harus ditampilkan
                        Intent intent = new Intent(LearnBuah.this, Favorit.class);
                        intent.putExtra("showCard", 3); // Mengirimkan informasi bahwa card2 harus ditampilkan
                        startActivity(intent);
                    }
                }, 1250); // Menunda selama 1 detik (1000 milidetik)
            }
        });

        ImageView favorit4 = findViewById(R.id.favorit4);
        favorit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan Toast
                Toast.makeText(LearnBuah.this, "Item disimpan ke favorit", Toast.LENGTH_SHORT).show();

                // Menggunakan Handler untuk menunda intent selama 1 detik
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Menggunakan Intent untuk berpindah ke Favorit Activity dan mengirimkan informasi bahwa card2 harus ditampilkan
                        Intent intent = new Intent(LearnBuah.this, Favorit.class);
                        intent.putExtra("showCard", 4); // Mengirimkan informasi bahwa card2 harus ditampilkan
                        startActivity(intent);
                    }
                }, 1250); // Menunda selama 1 detik (1000 milidetik)
            }
        });

        ImageView favorit5 = findViewById(R.id.favorit5);
        favorit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan Toast
                Toast.makeText(LearnBuah.this, "Item disimpan ke favorit", Toast.LENGTH_SHORT).show();

                // Menggunakan Handler untuk menunda intent selama 1 detik
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Menggunakan Intent untuk berpindah ke Favorit Activity dan mengirimkan informasi bahwa card2 harus ditampilkan
                        Intent intent = new Intent(LearnBuah.this, Favorit.class);
                        intent.putExtra("showCard", 5); // Mengirimkan informasi bahwa card2 harus ditampilkan
                        startActivity(intent);
                    }
                }, 1250); // Menunda selama 1 detik (1000 milidetik)
            }
        });

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