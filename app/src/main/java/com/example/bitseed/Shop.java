package com.example.bitseed;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.bitseed.databinding.ActivityShopBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Shop extends FragmentActivity implements OnMapReadyCallback {

    private static final int Request_CODE = 101;
    private GoogleMap mMap;
    private ActivityShopBinding binding;

    ImageView to_home, to_learn, to_profile;

    TextView nt1, nt2, nt3, nt4, nt5, nt6, at1, at2, at3, at4, at5, at6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nt1 = findViewById(R.id.namaToko1);
        nt2 = findViewById(R.id.namaToko2);
        nt3 = findViewById(R.id.namaToko3);
        nt4 = findViewById(R.id.namaToko4);
        nt5 = findViewById(R.id.namaToko5);
        nt6 = findViewById(R.id.namaToko6);

        at1 = findViewById(R.id.alamatToko1);
        at2 = findViewById(R.id.alamatToko2);
        at3 = findViewById(R.id.alamatToko3);
        at4 = findViewById(R.id.alamatToko4);
        at5 = findViewById(R.id.alamatToko5);
        at6 = findViewById(R.id.alamatToko6);


        getToko(null);

        to_home = findViewById(R.id.home_nav);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Shop.this, HomePage.class);
                startActivity(i);
            }
        });

        to_learn = findViewById(R.id.learn_nav);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Shop.this, Learn.class);
                startActivity(i);
            }
        });

        to_profile = findViewById(R.id.profile_nav);
        to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Shop.this, Profile.class);
                startActivity(i);
            }
        });

        checkPermission();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker for Agen pupuk NASA Cibinong Bogor
        LatLng agenPupukNASA = new LatLng(-6.458978460986298, 106.81157422427358);
        mMap.addMarker(new MarkerOptions().position(agenPupukNASA).title("Agen pupuk NASA Cibinong Bogor")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Jual Bibit Tanaman Buah
        LatLng jualBibitTanamanBuah = new LatLng(-6.568570543893151, 106.80596412470979);
        mMap.addMarker(new MarkerOptions().position(jualBibitTanamanBuah).title("Jual Bibit Tanaman Buah")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Centra Benih Bogor
        LatLng centraBenihBogor = new LatLng(-6.580500930000184, 106.8181672058527);
        mMap.addMarker(new MarkerOptions().position(centraBenihBogor).title("Centra Benih Bogor")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Bogor Nursery
        LatLng bogorNursery = new LatLng(-6.603314956594868, 106.81918791047603);
        mMap.addMarker(new MarkerOptions().position(bogorNursery).title("Bogor Nursery")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Lapak Bibit
        LatLng lapakBibit = new LatLng(-6.486197737084735, 106.81100393824069);
        mMap.addMarker(new MarkerOptions().position(lapakBibit).title("Lapak Bibit")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Karya Duta Tani
        LatLng karyaDutaTani = new LatLng(-6.635442651211802, 106.81181249769404);
        mMap.addMarker(new MarkerOptions().position(karyaDutaTani).title("Karya Duta Tani")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Aneka Tani
        LatLng anekaTani = new LatLng(-6.495166574819776, 106.78730153160359);
        mMap.addMarker(new MarkerOptions().position(anekaTani).title("Aneka Tani")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Kios Pupuk Alam Tani
        LatLng kiosPupukAlamTani = new LatLng(-6.51758289944614, 106.75204432145385);
        mMap.addMarker(new MarkerOptions().position(kiosPupukAlamTani).title("Kios Pupuk Alam Tani")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Florina (Jual Pohon, Pupuk, Pot)
        LatLng florinaJualPohonPupukPot = new LatLng(-6.568785300856317, 106.75641580655879);
        mMap.addMarker(new MarkerOptions().position(florinaJualPohonPupukPot).title("Florina (Jual Pohon, Pupuk, Pot)")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Toko Pupuk Berkah Tani
        LatLng tokoPupukBerkahTani = new LatLng(-6.475184828019264, 106.87614370408838);
        mMap.addMarker(new MarkerOptions().position(tokoPupukBerkahTani).title("Toko Pupuk Berkah Tani")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Toko Pupuk Berkah Tani
        LatLng kiosPupukTelagaTani = new LatLng(-6.577472281442489, 106.84258001684266);
        mMap.addMarker(new MarkerOptions().position(kiosPupukTelagaTani).title("Kios Pupuk Telaga Tani")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Move the camera to Sukaraja and apply zoom
        LatLng sukaraja = new LatLng(-6.526819582231175, 106.8001136577728);
        CameraUpdate center = CameraUpdateFactory.newLatLng(sukaraja);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
        mMap.moveCamera(center);
        mMap.moveCamera(zoom);
    }

    private BitmapDescriptor bitmapDescriptor(Context context, int vectorResId, int width, int height){
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, width, height); // Set width and height
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private void checkPermission(){
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_CODE);
            return;
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (Request_CODE){
            case Request_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    checkPermission();
                }
        }
    }

    public void getToko(View view) {
        String urlEndPoints = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-srael/endpoint/getAllToko";
        StringRequest sr = new StringRequest(
                Request.Method.GET,
                urlEndPoints,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if (response != null && !response.isEmpty()) {
                                JSONArray resultToko = new JSONArray(response);

                                for (int i = 0; i < Math.min(resultToko.length(), 6); i++) {
                                    JSONObject toko = resultToko.getJSONObject(i);

                                    String nama = toko.getString("nama");
                                    String alamat = toko.getString("alamat");

                                    switch (i) {
                                        case 0:
                                            nt1.setText(nama);
                                            at1.setText(alamat);
                                            break;
                                        case 1:
                                            nt2.setText(nama);
                                            at2.setText(alamat);
                                            break;
                                        case 2:
                                            nt3.setText(nama);
                                            at3.setText(alamat);
                                            break;
                                        case 3:
                                            nt4.setText(nama);
                                            at4.setText(alamat);
                                            break;
                                        case 4:
                                            nt5.setText(nama);
                                            at5.setText(alamat);
                                            break;
                                        case 5:
                                            nt6.setText(nama);
                                            at6.setText(alamat);
                                            break;
                                    }
                                }
                            } else {
                                Toast.makeText(Shop.this, "Empty response received", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Shop.this, "Error parsing JSON response", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Shop.this, "Error: " + error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Add the request to the RequestQueue
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
        rq.add(sr);
    }


}
