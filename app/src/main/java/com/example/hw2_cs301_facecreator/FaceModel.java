package com.example.hw2_cs301_facecreator;

import android.graphics.Color;
// @Author John Nicholson
import java.util.Random;

public class FaceModel {
   public int skinColor;
    public int eyeColor;
    public int hairColor;
   public int hairStyle;
    public FaceModel() {
        randomize();
    }
    public void randomize(){
        Random rdm = new Random();
        skinColor = Color.rgb(rdm.nextInt(255),rdm.nextInt(255),rdm.nextInt(255) );
        eyeColor = Color.rgb(rdm.nextInt(255),rdm.nextInt(255),rdm.nextInt(255) );
        hairColor = Color.rgb(rdm.nextInt(255),rdm.nextInt(255),rdm.nextInt(255) );
        hairStyle = rdm.nextInt(3);

    }
    public int getColor(int item) {
        if (item == 0) {
            return hairColor;
        }
        if(item == 1) {
            return eyeColor;
        }
        if(item == 2) {
            return skinColor;
        }
        return -1;
    }
    public void setColor(int color, int item) {
        if (item == 0) {
            hairColor = color;
        }
        if(item == 1) {
            eyeColor = color;
        }
        if(item == 2) {
            skinColor = color;
        }
    }


}
