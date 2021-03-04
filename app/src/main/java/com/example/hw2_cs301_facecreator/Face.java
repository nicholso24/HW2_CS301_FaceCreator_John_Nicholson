//@Author John Nicholson
package com.example.hw2_cs301_facecreator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView  {
    private FaceModel faceModel;
    final static int FACE_RADIUS = 500;

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.faceModel = new FaceModel();

        setWillNotDraw(false);

    }




    public void onDraw(Canvas canvas) {
        Paint faceColor = new Paint();
        faceColor.setColor(this.faceModel.skinColor);
        canvas.drawCircle(900, 550, FACE_RADIUS, faceColor);
        drawHair(canvas);
        drawEyes(canvas);

    }
    public void drawHair(Canvas canvas) {
        Paint colorOfHair = new Paint();
        colorOfHair.setColor(this.faceModel.hairColor);
        if(this.faceModel.hairStyle == 0) {
            canvas.drawOval(900f - FACE_RADIUS, 550f - FACE_RADIUS, 1400f, 450, colorOfHair); // Long Hair
        }
        if(this.faceModel.hairStyle == 1) {
            canvas.drawOval(900f - FACE_RADIUS / 2 , 550f - FACE_RADIUS, 1150f, 400, colorOfHair); // Short Hair
        }
        if(this.faceModel.hairStyle == 2) {
         // Bald
        }

    }
    public void drawEyes(Canvas canvas) {
        Paint colorOfEyes = new Paint();
        colorOfEyes.setColor(this.faceModel.eyeColor);
        canvas.drawCircle(900 - 100, 550, 20, colorOfEyes); // Left eye
        canvas.drawCircle(900 + 100, 550f, 20, colorOfEyes); // Right eye

    }
    public FaceModel getFaceModel() {
        return this.faceModel;
    }




}
