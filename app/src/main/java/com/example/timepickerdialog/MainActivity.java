package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView timeP;

    /*TimePickerDialog requires TimeSetListener which helps to get the time after clicking Ok in Dialog*/
    private TimePickerDialog.OnTimeSetListener timeSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeP = (TextView) findViewById(R.id.timeP);

        timeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Singleton Class Calendar is used to get Hour and Minute
                 */
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                /*
                * TimePicker Dialog Class requires five Parameters
                * Context
                * TimeSetListenet (CallBack Function)
                * hour
                * minute
                * false/true: If its sets to false it will show the time in 24 hour format else not
                */
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this,
                        timeSetListener,
                        hour, min, false);

                dialog.show();
            }
        });

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String currTime = hourOfDay + ":" + minute;
                timeP.setText(currTime);
            }
        };
    }
}
