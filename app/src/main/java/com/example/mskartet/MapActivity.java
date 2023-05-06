package com.example.mskartet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng lunner = new LatLng(60.152666, 10.766212);
        googleMap.addMarker(new MarkerOptions()
                .position(lunner)
                .title("Lunner Motorsport"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(lunner));

        LatLng jevnaker = new LatLng(60.228075, 10.338379);
        googleMap.addMarker(new MarkerOptions()
                .position(jevnaker)
                .title("Jevnaker Motorklubb"));

        LatLng gjerdrum = new LatLng(60.064787, 11.008858);
        googleMap.addMarker(new MarkerOptions()
                .position(gjerdrum)
                .title("Gjerdrum Motorklubb"));

        LatLng enebakk = new LatLng(59.730706, 11.144231);
        googleMap.addMarker(new MarkerOptions()
                .position(enebakk)
                .title("Enebakk Motorsportklubb"));

        LatLng bunes = new LatLng(59.665959, 11.761191);
        googleMap.addMarker(new MarkerOptions()
                .position(bunes)
                .title("Bunes Idrettslaget"));

        LatLng lier = new LatLng(59.800574, 10.287997);
        googleMap.addMarker(new MarkerOptions()
                .position(lier)
                .title("Lier Motorsportklubb"));

        LatLng gardermoen = new LatLng(60.188589, 11.135093);
        googleMap.addMarker(new MarkerOptions()
                .position(gardermoen)
                .title("Gardermoen Motorcrossbane"));

        LatLng kongsvinger = new LatLng(60.247428, 12.125493);
        googleMap.addMarker(new MarkerOptions()
                .position(kongsvinger)
                .title("Kongsvinger Motorklubb"));

        LatLng haslemoen = new LatLng(60.655043, 11.879655);
        googleMap.addMarker(new MarkerOptions()
                .position(haslemoen)
                .title("Haslemoen Motorcrossbane"));

        LatLng starmoen = new LatLng(60.863302, 11.685858);
        googleMap.addMarker(new MarkerOptions()
                .position(starmoen)
                .title("Starmoen Motorsenter"));

        LatLng bøverlund = new LatLng(61.044277, 10.832051);
        googleMap.addMarker(new MarkerOptions()
                .position(bøverlund)
                .title("Bøverlund Motorcrossbane"));

        LatLng ål = new LatLng(60.642294, 8.600979);
        googleMap.addMarker(new MarkerOptions()
                .position(ål)
                .title("Ål MotorCrossbane"));

        LatLng fuglehaugen = new LatLng(60.798471, 8.772668);
        googleMap.addMarker(new MarkerOptions()
                .position(fuglehaugen)
                .title("Fuglehaugen MotorCrossbane"));

        LatLng valdres = new LatLng(61.093315, 9.026538);
        googleMap.addMarker(new MarkerOptions()
                .position(valdres)
                .title("Valdres MotorCross"));

        LatLng storelvdal = new LatLng(61.598554, 10.994851);
        googleMap.addMarker(new MarkerOptions()
                .position(storelvdal)
                .title("Stor-Elvdal MotorCross"));

        LatLng nmktrysil = new LatLng(61.231750, 12.267718);
        googleMap.addMarker(new MarkerOptions()
                .position(nmktrysil)
                .title("NMK Trysil MotorCross & Bilcross"));

        LatLng slettholen = new LatLng(60.452830, 11.442625);
        googleMap.addMarker(new MarkerOptions()
                .position(slettholen)
                .title("Slettholen Motorcross"));

        LatLng magnor = new LatLng(59.952597, 12.176493);
        googleMap.addMarker(new MarkerOptions()
                .position(magnor)
                .title("Magnor Motorcross"));
    }

    public void startActivityMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}