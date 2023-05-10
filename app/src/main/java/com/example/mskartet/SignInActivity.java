package com.example.mskartet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    private HashMap<String, String> users = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        users.put("LunnerMotorsport", "pass2");
        users.put("JevnakerMotorklubb", "pass2");
        users.put("GjerdrumMotorklubb", "pass2");
        users.put("EnebakkMotorsportklubb", "pass2");
        users.put("BunesIdrettslaget", "pass2");
        users.put("LierMotorsportklubb", "pass2");
        users.put("GardermoenMotorcrossbane", "pass2");
        users.put("KongsvingerMotorklubb", "pass2");
        users.put("HaslemoenMotorcrossbane", "pass2");
        users.put("StarmoenMotorsenter", "pass2");

        users.put("BøverlundMotorcrossbane", "pass2");
        users.put("ÅlMotorCrossbane", "pass2");
        users.put("FuglehaugenMotorCrossbane", "pass2");
        users.put("ValdresMotorCross", "pass2");
        users.put("Stor-ElvdalMotorCross", "pass2");
        users.put("NMKTrysilMotorCross&Bilcross", "pass2");
        users.put("SlettholenMotorcross", "pass2");
        users.put("MagnorMotorcross", "pass2");
        users.put("EidskogMX", "pass2");

        // Legg til flere brukernavn og passord
        //må også legge til flere lokasjoner og collection i firestore/firebase

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                if(users.containsKey(inputUsername) && users.get(inputUsername).equals(inputPassword)){
                    //correct
                    Toast.makeText(SignInActivity.this,"Logger Inn!",Toast.LENGTH_SHORT).show();

                    String username = inputUsername;
                    Intent intent = new Intent(SignInActivity.this, DescriptionActivity.class);
                    intent.putExtra("username", username); // replace "username" with whatever key you want to use
                    startActivity(intent);
                } else {
                    //incorrect
                    Toast.makeText(SignInActivity.this,"Feil ved innlogging.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

