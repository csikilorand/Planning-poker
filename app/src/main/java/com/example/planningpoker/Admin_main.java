package com.hfad.scrum_poker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import  static android.content.ContentValues.TAG;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> arrayList = new ArrayList<>();
    Story story;
    ArrayAdapter <String> arrayAdapter;
    String clickedItem = "";
    String addedStory = "";

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String username,password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("messsage");
        myRef.setValue("Hel324342lo World");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, "Connected to firebase", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //loggolni
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });



        final Spinner spinner = findViewById(R.id.spinner);
        EditText storyValue = findViewById(R.id.storyValue);
        Button newStory = findViewById(R.id.newStory);
        Button editStory = findViewById(R.id.editButton);
        Button deleteStory = findViewById(R.id.deleteStory);
        Button deleteAll = findViewById(R.id.deleteAll);
        Button start = findViewById(R.id.startButton);


        arrayList.add("JAVA");
        arrayList.add("ANDROID");
        arrayList.add("C Language");
        arrayList.add("CPP Language");
        arrayList.add("Go Language");
        arrayList.add("AVN SYSTEMS");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrayList );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                clickedItem = "" + parent.getSelectedItem();
                //Toast.makeText(MainActivity.this, clickedItem + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // spinner.setSelection(0);
        //spinner.s

        //getting data from spinner
        // final String storyText = String.valueOf(spinner.getSelectedItem());
        //storyValue.setText(story.getValue());


        newStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add new story
                final EditText storyInput = new EditText(MainActivity.this);
                //storyInput.setSingleLine();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add new Story")
                        .setMessage("What is the story")
                        .setView(storyInput)
                        .setPositiveButton("Add story", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                addedStory = storyInput.getText().toString();
                                arrayList.add(addedStory);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertDialog.show();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CycleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Text", clickedItem);
                bundle.putDouble("Value", 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        editStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //can be modified
                final EditText getStory = new EditText(MainActivity.this);
                getStory.setText(clickedItem);
                //Toast.makeText(MainActivity.this, getStory + " selected", Toast.LENGTH_SHORT).show();

                //alert dialog
                final  AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Editing a story")
                        .setMessage("Tap Save to save")
                        .setView(getStory)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //getStory.setText(clickedItem);
                                //                Toast.makeText(MainActivity.this, getStory + " selected", Toast.LENGTH_SHORT).show();//itt nem kapja meg
                                arrayList.add(getStory.getText().toString());
                                arrayAdapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("Nope", null)

                        .create();
                alertDialog.show();
            }
        });


        deleteStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Deleting a story")
                        .setMessage("You sure to delete it?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this, clickedItem + " selected", Toast.LENGTH_SHORT).show();
                                arrayList.remove(clickedItem);
                                arrayAdapter.notifyDataSetChanged();
                                // spinner.setAdapter(arrayAdapter);

                            }
                        })
                        .setNegativeButton("Nope", null)
                        .create();
                alertDialog.show();
            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete All")
                        .setMessage("You sure to delete all stories?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.clear();
                            }
                        })
                        .setNegativeButton("Nope", null)
                        .create();
                alertDialog.show();


            }
        });

//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CycleActivity.class);
//                //megBundle-ezni
//            }
//        });
    }


    public void updateSpinner(Spinner spinner, ArrayAdapter<String> arrayAdapter){
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrayList );

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(0);

    }



}
