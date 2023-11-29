package com.example.bitseed;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    TextView to_register;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        to_register = findViewById(R.id.textViewRegisterNow);
        to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                new LoginTask().execute(email, password);
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String password = params[1];
            String apiUrl = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-srael/endpoint/getAllPengguna"; // Ganti dengan URL endpoint MongoDB Anda

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    boolean emailRegistered = false;

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String dbEmail = jsonObject.getString("email");
                        String dbPassword = jsonObject.getString("password");

                        if (dbEmail.equals(editTextEmail.getText().toString()) &&
                                dbPassword.equals(editTextPassword.getText().toString())) {
                            // Cocok, pindah ke Activity homepage
                            Intent intent = new Intent(Login.this, HomePage.class);
                            startActivity(intent);
                            return;
                        } else if (dbEmail.equals(editTextEmail.getText().toString())) {
                            // Email terdaftar tetapi password tidak cocok
                            emailRegistered = true;
                            break;
                        }
                    }

                    // Tidak ada yang cocok
                    if (emailRegistered) {
                        Toast.makeText(Login.this, "Password salah. Silahkan coba lagi.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Email tidak terdaftar. Silahkan lakukan registrasi telebih dahulu.", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                // Gagal mendapatkan data dari server
                Toast.makeText(Login.this, "Failed to fetch data from server", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
