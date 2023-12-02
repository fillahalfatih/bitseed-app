package com.example.bitseed;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    ImageView to_home, to_learn, to_shop, back_nav;
    TextView logout, edit, emailPengguna, statusPengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Profile.this, HomePage.class);
                startActivity(i);
            }
        });

        to_learn = findViewById(R.id.learn_nav);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Profile.this, Learn.class);
                startActivity(i);
            }
        });

        to_shop = findViewById(R.id.shop_nav);
        to_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Profile.this, Shop.class);
                startActivity(i);
            }
        });

        back_nav = findViewById(R.id.back_nav);
        back_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Profile.this, HomePage.class);
                startActivity(i);
            }
        });

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Edit.class);
                intent.putExtra("email", emailPengguna.getText().toString());
                intent.putExtra("status", statusPengguna.getText().toString());
                startActivityForResult(intent, 1);
            }
        });

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Profile.this, Login.class);
                startActivity(i);
            }
        });

        // Find TextViews in your XML layout
        emailPengguna = findViewById(R.id.emailPengguna);
        statusPengguna = findViewById(R.id.statusPengguna);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                // Update the TextViews with the edited values
                String updatedEmail = data.getStringExtra("updatedEmail");
                String updatedStatus = data.getStringExtra("updatedStatus");

                emailPengguna.setText(updatedEmail);
                statusPengguna.setText(updatedStatus);
            }
        }
    }
}
