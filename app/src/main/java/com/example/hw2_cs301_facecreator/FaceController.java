// @Author John Nicholson
package com.example.hw2_cs301_facecreator;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

public class FaceController implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
    private Face faceView;
    private FaceModel faceModel;
    int selectedRadio;
    public int seekBarPosition;

    public FaceController(Face faceView) {
        this.faceView = faceView;
        this.faceModel = this.faceView.getFaceModel();
        // Initially set seek bar here
        seekBarPosition = this.faceModel.getColor(selectedRadio);




    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int redChange = red(this.faceModel.getColor(selectedRadio));
        int greenChange = green(this.faceModel.getColor(selectedRadio));
        int blueChange = blue(this.faceModel.getColor(selectedRadio));
        if (seekBar.getId() == R.id.redSeekBar) {
            redChange = progress;
        }
        if (seekBar.getId() == R.id.blueSeekBar) {
            blueChange = progress;

        }
        if (seekBar.getId() == R.id.greenSeekBar) {
            greenChange = progress;
        }
        this.faceModel.setColor(Color.rgb(redChange, greenChange, blueChange), selectedRadio);
        faceView.invalidate();
    }

        @Override
        public void onStartTrackingTouch (SeekBar seekBar){
            seekBar.setProgress(seekBarPosition);

        }

        @Override
        public void onStopTrackingTouch (SeekBar seekBar){

        }

        @Override
        public void onClick (View v){
            this.faceModel.randomize();

            faceView.invalidate();
        }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(checkedId == R.id.hairRadioButton) {
            selectedRadio = 0;
        }
        if(checkedId == R.id.eyeRadioButton) {
            selectedRadio = 1;
        }
        if(checkedId == R.id.skinRadioButton) {
            selectedRadio = 2;
        }

        Log.d("hello", "radioButton was checked");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("test", "Hair Style Changed");
        this.faceModel.hairStyle = parent.getSelectedItemPosition();
        faceView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}




