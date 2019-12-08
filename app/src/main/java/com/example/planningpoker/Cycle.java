package com.hfad.scrum_poker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle);
        Bundle bundle = getIntent().getExtras();
        String story = bundle.getString("Text");
        double value = bundle.getDouble("Value");

        EditText storyText = findViewById(R.id.storyText);
        EditText storyValue = findViewById(R.id.storyValue);
        EditText dateAndTime = findViewById(R.id.Date);
        Button go = findViewById(R.id.go);


        storyText.setText(story);
        storyValue.setText(""+value);

        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm ");
        dateAndTime.setText(date.format(new Date()));


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //upload to Firebase
            }
        });


    }
}
