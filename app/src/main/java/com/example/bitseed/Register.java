package com.example.bitseed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    TextView to_login;
    Button buttonRegister, to_homepage;
    EditText editTextEmail, editTextPassword, editTextPasswordNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        to_login = findViewById(R.id.textViewLoginNow);
        to_homepage = findViewById(R.id.buttonRegister);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordNew = findViewById(R.id.editTextPasswordNew);

        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

    }

    public void register() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextPasswordNew.getText().toString().trim();

        // Cek apakah editText kosong
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Semua data harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Cek apakah password dan confirmPassword sama
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Password dan Confirm Password harus sama", Toast.LENGTH_SHORT).show();
            return;
        }

        // Jika data sudah valid, kirim data ke MongoDB menggunakan Volley
        String urlEndpoint = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-srael/endpoint/insertPengguna";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                urlEndpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle response dari server jika diperlukan
                        Toast.makeText(Register.this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();

                        // Arahkan pengguna ke activity Login
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                        finish(); // Optional: Menutup activity saat ini agar tidak bisa kembali ke halaman registrasi
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                // Menyiapkan data untuk dikirim ke server
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        // Menambahkan request ke queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}
