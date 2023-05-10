package com.example.mskartet;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class DescriptionViewActivity extends AppCompatActivity {

    private static final String TAG = "DescriptionViewActivity";

    private FirebaseFirestore db;
    private TextView usernameTextView;
    private TextView descriptionTextView;
    private TextView[] timeTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptionview);

        db = FirebaseFirestore.getInstance();

        usernameTextView = findViewById(R.id.username_textview);
        descriptionTextView = findViewById(R.id.description_textview);

        timeTextViews = new TextView[7];
        timeTextViews[0] = findViewById(R.id.monday_time_textview);
        timeTextViews[1] = findViewById(R.id.tuesday_time_textview);
        timeTextViews[2] = findViewById(R.id.wednesday_time_textview);
        timeTextViews[3] = findViewById(R.id.thursday_time_textview);
        timeTextViews[4] = findViewById(R.id.friday_time_textview);
        timeTextViews[5] = findViewById(R.id.saturday_time_textview);
        timeTextViews[6] = findViewById(R.id.sunday_time_textview);

        // Get the marker name from the Intent extras
        String markerName = getIntent().getStringExtra("markerName");

        // Set the marker name in the usernameTextView
        usernameTextView.setText(markerName);

        // Query the collection with matching marker name
        CollectionReference markerRef = db.collection(markerName);
        markerRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot snapshot = task.getResult();
                    if (snapshot.isEmpty()) {
                        Toast.makeText(DescriptionViewActivity.this, "No data found for the marker.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    DocumentSnapshot document = snapshot.getDocuments().get(0);
                    String description = document.getString("description");
                    List<String> times = (List<String>) document.get("times");

                    descriptionTextView.setText(description);

                    for (int i = 0; i < times.size(); i++) {
                        timeTextViews[i].setText(times.get(i));
                    }

                } else {
                    Log.e(TAG, "Error getting documents: ", task.getException());
                    Toast.makeText(DescriptionViewActivity.this, "Error getting data for the marker.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}