package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Cards extends AppCompatActivity implements View.OnClickListener {

    Button button2,button4,button5,button6,button7,button8,button9,button10,button11,button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        button2 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);

        button2.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button2:
                button2.setText("0");

                break;

            case R.id.button4:
                button4.setText("1");

                break;

            case R.id.button5:
                button5.setText("2");

                break;

            case R.id.button6:
                button6.setText("3");

                break;

            case R.id.button7:
                button7.setText("5");

                break;

            case R.id.button8:
                button8.setText("8");

                break;

            case R.id.button9:
                button9.setText("13");

                break;

            case R.id.button10:
                button10.setText("20");

                break;

            case R.id.button11:
                button11.setText("40");

                break;

            case R.id.button12:
                button12.setText("100");

                break;
        }
    }
}
