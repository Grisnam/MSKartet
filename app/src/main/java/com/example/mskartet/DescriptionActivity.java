package com.example.mskartet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class DescriptionActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private EditText descriptionField;
    private EditText[] timeFields;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.username);
        descriptionField = findViewById(R.id.description_field);

        timeFields = new EditText[7];
        timeFields[0] = findViewById(R.id.monday_time);
        timeFields[1] = findViewById(R.id.tuesday_time);
        timeFields[2] = findViewById(R.id.wednesday_time);
        timeFields[3] = findViewById(R.id.thursday_time);
        timeFields[4] = findViewById(R.id.friday_time);
        timeFields[5] = findViewById(R.id.saturday_time);
        timeFields[6] = findViewById(R.id.sunday_time);

        username.setText(mAuth.getCurrentUser().getEmail());

        Button saveBtn = findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = descriptionField.getText().toString();
                String[] times = new String[6];

                for (int i = 0; i < 7; i++) {
                    times[i] = timeFields[i].getText().toString();
                }

                Map<String, Object> data = new HashMap<>();
                data.put("description", description);
                data.put("times", times);

                String userId = mAuth.getCurrentUser().getUid();
                DocumentReference docRef = db.collection("users").document(userId);
                docRef.set(data, SetOptions.merge())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(DescriptionActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DescriptionActivity.this, "Error saving data.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}