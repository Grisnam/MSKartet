package com.example.mskartet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);



        LatLng lunner = new LatLng(60.152666, 10.766212);
        googleMap.addMarker(new MarkerOptions()
                .position(lunner)
                .title("LunnerMotorsport"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(lunner));

        LatLng jevnaker = new LatLng(60.228075, 10.338379);
        googleMap.addMarker(new MarkerOptions()
                .position(jevnaker)
                .title("JevnakerMotorklubb"));

        LatLng gjerdrum = new LatLng(60.064787, 11.008858);
        googleMap.addMarker(new MarkerOptions()
                .position(gjerdrum)
                .title("GjerdrumMotorklubb"));

        LatLng enebakk = new LatLng(59.730706, 11.144231);
        googleMap.addMarker(new MarkerOptions()
                .position(enebakk)
                .title("EnebakkMotorsportklubb"));

        LatLng bunes = new LatLng(59.665959, 11.761191);
        googleMap.addMarker(new MarkerOptions()
                .position(bunes)
                .title("BunesIdrettslaget"));

        LatLng lier = new LatLng(59.800574, 10.287997);
        googleMap.addMarker(new MarkerOptions()
                .position(lier)
                .title("LierMotorsportklubb"));

        LatLng gardermoen = new LatLng(60.188589, 11.135093);
        googleMap.addMarker(new MarkerOptions()
                .position(gardermoen)
                .title("GardermoenMotorcrossbane"));

        LatLng kongsvinger = new LatLng(60.247428, 12.125493);
        googleMap.addMarker(new MarkerOptions()
                .position(kongsvinger)
                .title("KongsvingerMotorklubb"));

        LatLng haslemoen = new LatLng(60.655043, 11.879655);
        googleMap.addMarker(new MarkerOptions()
                .position(haslemoen)
                .title("HaslemoenMotorcrossbane"));

        LatLng starmoen = new LatLng(60.863302, 11.685858);
        googleMap.addMarker(new MarkerOptions()
                .position(starmoen)
                .title("StarmoenMotorsenter"));

        LatLng bøverlund = new LatLng(61.044277, 10.832051);
        googleMap.addMarker(new MarkerOptions()
                .position(bøverlund)
                .title("BøverlundMotorcrossbane"));

        LatLng ål = new LatLng(60.642294, 8.600979);
        googleMap.addMarker(new MarkerOptions()
                .position(ål)
                .title("ÅlMotorCrossbane"));

        LatLng fuglehaugen = new LatLng(60.798471, 8.772668);
        googleMap.addMarker(new MarkerOptions()
                .position(fuglehaugen)
                .title("FuglehaugenMotorCrossbane"));

        LatLng valdres = new LatLng(61.093315, 9.026538);
        googleMap.addMarker(new MarkerOptions()
                .position(valdres)
                .title("ValdresMotorCross"));

        LatLng storelvdal = new LatLng(61.598554, 10.994851);
        googleMap.addMarker(new MarkerOptions()
                .position(storelvdal)
                .title("Stor-ElvdalMotorCross"));

        LatLng nmktrysil = new LatLng(61.231750, 12.267718);
        googleMap.addMarker(new MarkerOptions()
                .position(nmktrysil)
                .title("NMKTrysilMotorCross&Bilcross"));

        LatLng slettholen = new LatLng(60.452830, 11.442625);
        googleMap.addMarker(new MarkerOptions()
                .position(slettholen)
                .title("SlettholenMotorcross"));

        LatLng magnor = new LatLng(59.952597, 12.176493);
        googleMap.addMarker(new MarkerOptions()
                .position(magnor)
                .title("MagnorMotorcross"));

        LatLng eidskog = new LatLng(59.955019, 12.175973);
        googleMap.addMarker(new MarkerOptions()
                .position(eidskog)
                .title("EidskogMX"));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // Create a new InfoWindow with the marker's title as the text
                InfoWindowData data = new InfoWindowData(marker.getTitle());
                CustomInfoWindow infoWindow = new CustomInfoWindow(MapActivity.this);
                infoWindow.setData(data);

                // Set the InfoWindow as the marker's info window
                marker.showInfoWindow();
                marker.showInfoWindow();

                return true;
            }
        });

// Set a listener to start DescriptionViewActivity when the InfoWindow is clicked
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapActivity.this, DescriptionViewActivity.class);
                intent.putExtra("markerName", marker.getTitle());  // Pass the marker title as the markerName extra
                startActivity(intent);
            }
        });

    }






    public void startActivityMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}