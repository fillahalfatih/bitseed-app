package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class test extends AppCompatActivity {

    Button button, buttonRegister;
    TextView tv;

    EditText editTextEmail, editTextPassword, editTextPasswordNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        button = findViewById(R.id.btn01);
        tv = findViewById(R.id.tvResult);
    }

    public void getBuah(View view){
//        String urlEndPoints = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-srael/endpoint/getAllBuah";
        String urlEndPoints = "https://us-east-1.aws.data.mongodb-api.com/app/application-0-yuxyg/endpoint/getAllKopi";
        StringRequest sr = new StringRequest(
                Request.Method.GET,
                urlEndPoints,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray resultKopi = new JSONArray(response);
                            JSONObject kopi = resultKopi.getJSONObject(0);
                            String namanya = kopi.getString("nama");
                            String deskripsi = kopi.getString("deskripsi");

                            tv.setText(namanya + "\n\n" + deskripsi);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(test.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
        rq.add(sr);
    }
}