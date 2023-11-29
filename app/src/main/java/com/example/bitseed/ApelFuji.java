package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApelFuji extends AppCompatActivity {

    TextView nama_buah, kategori_produk, bagian_1, bagian_2, bagian_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apel_fuji);

        nama_buah = findViewById(R.id.namaBuah);
        kategori_produk = findViewById(R.id.kategoriBuah);
        bagian_1 = findViewById(R.id.persiapan);
        bagian_2 = findViewById(R.id.lahan);
        bagian_3 = findViewById(R.id.penanaman);

        getBuah(null);
    }

    public void getBuah(View view){
        String urlEndPoints = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-srael/endpoint/getAllBuah";
        StringRequest sr = new StringRequest(
                Request.Method.GET,
                urlEndPoints,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray resultBuah = new JSONArray(response);
                            JSONObject buah = resultBuah.getJSONObject(1);

                            String nama = buah.getString("nama");
                            String kategori = buah.getString("kategori");

                            JSONObject tataCara = buah.getJSONObject("tata_cara");
                            String prspn = tataCara.getString("persiapan");
                            String lhn = tataCara.getString("lahan");
                            String mnm = tataCara.getString("menanam");

                            nama_buah.setText(nama);
                            kategori_produk.setText(kategori);
                            bagian_1.setText(prspn);
                            bagian_2.setText(lhn);
                            bagian_3.setText(mnm);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ApelFuji.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
        rq.add(sr);
    }

}