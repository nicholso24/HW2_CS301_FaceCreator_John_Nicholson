// @Author John Nicholson
package com.example.hw2_cs301_facecreator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
 private Face myFaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFaceView = findViewById(R.id.surfaceView);

        FaceController faceController = new FaceController(myFaceView);

        Button randomizeButton = findViewById(R.id.randomizeButton);
        randomizeButton.setOnClickListener(faceController);

        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        greenBar.setProgress(faceController.seekBarPosition);
        greenBar.setOnSeekBarChangeListener(faceController);

        SeekBar blueBar = findViewById(R.id.blueSeekBar);
        blueBar.setProgress(faceController.seekBarPosition);
        blueBar.setOnSeekBarChangeListener(faceController);


        SeekBar redBar = findViewById(R.id.redSeekBar);
        redBar.setProgress(faceController.seekBarPosition);
        redBar.setOnSeekBarChangeListener(faceController);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(faceController);

        Spinner spinner = findViewById(R.id.hairStyleSpinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hairstyle_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(faceController);

    }
}