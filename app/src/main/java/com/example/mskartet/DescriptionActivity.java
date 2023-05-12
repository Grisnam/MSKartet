package com.example.mskartet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DescriptionActivity extends AppCompatActivity {
    private static final String TAG = "DescriptionActivity";

    private FirebaseFirestore db;
    private EditText descriptionField;
    private EditText[] timeFields;
    private TextView usernameTextView;

    public void startActivityMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);

    }

    public void startActivitySignIn(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String username = getIntent().getStringExtra("username");
        TextView usernameTextView = findViewById(R.id.username_textview);
        usernameTextView.setText(username);

        db = FirebaseFirestore.getInstance();

        usernameTextView = findViewById(R.id.username);
        descriptionField = findViewById(R.id.description_edittext);

        timeFields = new EditText[7];
        timeFields[0] = findViewById(R.id.monday_time);
        timeFields[1] = findViewById(R.id.tuesday_time);
        timeFields[2] = findViewById(R.id.wednesday_time);
        timeFields[3] = findViewById(R.id.thursday_time);
        timeFields[4] = findViewById(R.id.friday_time);
        timeFields[5] = findViewById(R.id.saturday_time);
        timeFields[6] = findViewById(R.id.sunday_time);

        // Retrieve the data from Firestore
        DocumentReference docRef = db.collection(username).document("user");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String description = document.getString("description");
                        List<String> times = (List<String>) document.get("times");

                        // Populate the EditText fields with the retrieved values
                        descriptionField.setText(description);
                        for (int i = 0; i < timeFields.length && i < times.size(); i++) {
                            timeFields[i].setText(times.get(i));
                        }
                    }
                } else {
                    Log.e(TAG, "Error getting document: ", task.getException());
                    Toast.makeText(DescriptionActivity.this, "Error retrieving data.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button saveBtn = findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = descriptionField.getText().toString();
                List<String> times = new ArrayList<>();

                for (int i = 0; i < 7; i++) {
                    times.add(timeFields[i].getText().toString());
                }

                Map<String, Object> data = new HashMap<>();
                data.put("description", description);
                data.put("times", times);

                DocumentReference docRef = db.collection(username).document("user");
                docRef.set(data, SetOptions.merge())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(DescriptionActivity.this, "Informasjonen ble lagret!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DescriptionActivity.this, "Kunne ikke lagre informasjon.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}