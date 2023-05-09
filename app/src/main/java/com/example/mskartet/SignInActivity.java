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

        users.put("LunnerMotorsport", "admin");
        users.put("user1", "pass1");
        users.put("user2", "pass2");
        // Legg til flere brukernavn og passord

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
                    Toast.makeText(SignInActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                    String username = inputUsername;
                    Intent intent = new Intent(SignInActivity.this, DescriptionActivity.class);
                    intent.putExtra("username", username); // replace "username" with whatever key you want to use
                    startActivity(intent);
                } else {
                    //incorrect
                    Toast.makeText(SignInActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

