package com.example.bitseed;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.bitseed.databinding.ActivityShopMapsBinding;

public class ShopMaps extends FragmentActivity implements OnMapReadyCallback {

    private static final int Request_CODE = 101;
    private GoogleMap mMap;
    private ActivityShopMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShopMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkPermission();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker for benihkita
        LatLng benihkita = new LatLng(-6.420603084589779, 106.78226551334866);
        mMap.addMarker(new MarkerOptions().position(benihkita).title("benihkita.com")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Add a marker for Tani Subur Makmur
        LatLng taniSuburMakmur = new LatLng(-6.370473910872553, 106.88301959985587);
        mMap.addMarker(new MarkerOptions().position(taniSuburMakmur).title("Tani Subur Makmur")
                .icon(bitmapDescriptor(getApplicationContext(), R.drawable.location, 100, 100))); // Set width and height as needed

        // Move the camera to benihkita and apply zoom
        CameraUpdate center = CameraUpdateFactory.newLatLng(benihkita);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);
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
}
