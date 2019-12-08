package com.hfad.scrum_poker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

//https://www.mountaingoatsoftware.com/agile/planning-poker


public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        int cards[] = { 0, 1, 2, 3, 5, 8, 13, 20, 40, 100};

        EditText givenStoryValue = findViewById(R.id.storyValue);
        TextView givenStoryText = findViewById(R.id.storyText);



    }



    public boolean isValueCorrect(int number, int array[]){
        for(int i=0; i<array.length; ++i){
            if (number == array[i])
                return true;
        }
        return false;
    }
}
