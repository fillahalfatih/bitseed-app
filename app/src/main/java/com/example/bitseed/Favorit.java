package com.example.bitseed;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Favorit extends AppCompatActivity {

    ImageView to_home, to_learn, to_shop, to_profile;

    private List<TextView> namaBuahTextViewList;
    private List<TextView> kategoriBuahTextViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Favorit.this, HomePage.class);
                startActivity(i);
            }
        });

        to_learn = findViewById(R.id.learn_nav);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Favorit.this, Learn.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Favorit.this, Shop.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Favorit.this, Profile.class);
                startActivity(i);
            }
        });

        namaBuahTextViewList = new ArrayList<>();
        kategoriBuahTextViewList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int namaBuahId = getResources().getIdentifier("namaBuah" + i, "id", getPackageName());
            int kategoriBuahId = getResources().getIdentifier("kategoriBuah" + i, "id", getPackageName());

            TextView namaBuahTextView = findViewById(namaBuahId);
            TextView kategoriBuahTextView = findViewById(kategoriBuahId);

            namaBuahTextViewList.add(namaBuahTextView);
            kategoriBuahTextViewList.add(kategoriBuahTextView);
        }

        // Memeriksa apakah ada Intent yang membawa informasi untuk menampilkan card tertentu
        Intent intent = getIntent();
        if (intent.hasExtra("showCard")) {
            int cardToShow = intent.getIntExtra("showCard", 0);

            // Menampilkan CardView sesuai dengan informasi yang diterima dari Intent
            int cardId = getResources().getIdentifier("card" + cardToShow, "id", getPackageName());
            LinearLayout cardView = findViewById(cardId);

            if (cardView != null) {
                cardView.setVisibility(View.VISIBLE);
            }
        }

        new FetchDataFromMongoDB().execute();

        // Tambahkan OnClickListener untuk delete1 hingga delete5
        setDeleteOnClickListener(1, R.id.delete1);
        setDeleteOnClickListener(2, R.id.delete2);
        setDeleteOnClickListener(3, R.id.delete3);
        setDeleteOnClickListener(4, R.id.delete4);
        setDeleteOnClickListener(5, R.id.delete5);
    }

    private void setDeleteOnClickListener(final int cardIndex, int deleteImageViewId) {
        ImageView deleteImageView = findViewById(deleteImageViewId);
        deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menyembunyikan CardView berdasarkan indeks
                hideCard(cardIndex);
                // Menampilkan Toast
                Toast.makeText(Favorit.this, "Item berhasil dihapus", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class FetchDataFromMongoDB extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-srael/endpoint/getAllFavorit");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                try {
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    return result.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (IOException e) {
                Log.e("Favorit", "Error fetching data from MongoDB", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null) {
                try {
                    JSONArray jsonArray = new JSONArray(result);

                    // Iterasi melalui array dan mengisi TextView sesuai dengan indeks
                    for (int i = 0; i < Math.min(jsonArray.length(), 5); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        // Ambil nilai dari kunci "nama" dan "kategori"
                        String namaBuah = jsonObject.getString("nama");
                        String kategoriBuah = jsonObject.getString("kategori");

                        // Set nilai ke dalam TextView
                        namaBuahTextViewList.get(i).setText(namaBuah);
                        kategoriBuahTextViewList.get(i).setText(kategoriBuah);

                        // Menyembunyikan CardView berdasarkan indeks
                        int cardId = getResources().getIdentifier("card" + (i + 1), "id", getPackageName());
                        LinearLayout cardView = findViewById(cardId);

                        if (cardView != null) {
                            // Menyembunyikan semua CardView
                            cardView.setVisibility(View.GONE);

                            // Memeriksa apakah CardView harus ditampilkan
                            Intent intent = getIntent();
                            if (intent.hasExtra("showCard")) {
                                int cardToShow = intent.getIntExtra("showCard", 0);

                                if (cardToShow == (i + 1)) {
                                    // Menampilkan CardView sesuai dengan informasi yang diterima dari Intent
                                    cardView.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    Log.e("Favorit", "Error parsing JSON", e);
                }
            }
        }
    }

    // Fungsi untuk menyembunyikan CardView berdasarkan indeks
    private void hideCard(int cardIndex) {
        int cardId = getResources().getIdentifier("card" + cardIndex, "id", getPackageName());
        LinearLayout cardView = findViewById(cardId);

        if (cardView != null) {
            cardView.setVisibility(View.GONE);
        }
    }
}
