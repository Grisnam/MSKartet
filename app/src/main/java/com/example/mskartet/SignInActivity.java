package com.example.mskartet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class SignInActivity extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        TextView BrukerNavn =(TextView) findViewById(R.id.BrukerNavn);
        TextView Passord =(TextView) findViewById(R.id.Passord);

        MaterialButton logginnbtn = (MaterialButton) findViewById(R.id.logginnbtn);
        //admin admin
        logginnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {if(BrukerNavn.getText() .toString().equals("admin") && Passord.getText().toString().equals("admin")){
                //correct
                Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
            }else
                //incorrect
                Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }

        });
    }
    }


