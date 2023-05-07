package com.example.mskartet;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import org.threeten.bp.LocalTime;

public class EventEditActivity extends AppCompatActivity {
    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText(getString(R.string.event_date, CalendarUtils.formattedDate(CalendarUtils.selectedDate)));
        eventTimeTV.setText(getString(R.string.event_time, CalendarUtils.formattedTime(time)));

        // Add OnClickListener to the eventTimeTV TextView
        eventTimeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch a TimePickerDialog to allow the user to select a new time
                int hour = time.getHour();
                int minute = time.getMinute();
                TimePickerDialog timePickerDialog = new TimePickerDialog(EventEditActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Update the selected time and the UI
                                time = LocalTime.of(hourOfDay, minute);
                                eventTimeTV.setText(getString(R.string.event_time, CalendarUtils.formattedTime(time)));
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });
    }

    private void initWidgets() {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view) {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);

        // Add the event to the SQLite database
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.addEvent(eventName, CalendarUtils.selectedDate, time);

        // Add the event to the events list
        Event.eventsList.add(newEvent);
        finish();
    }

}