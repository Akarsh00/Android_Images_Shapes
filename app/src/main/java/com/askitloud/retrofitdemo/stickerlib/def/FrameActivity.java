package com.askitloud.retrofitdemo.stickerlib.def;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.askitloud.retrofitdemo.stickerlib.R;

public class FrameActivity extends AppCompatActivity {
    Bitmap bitmap;
    ImageView imageView;
    public static final String EDITED_WHITE_IMAGE_SUFFIX = "_white.jpg";
    public static final int FLIP_VERTICAL = 1;
    public static final int FLIP_HORIZONTAL = 2;
    public static final String DRAWABLE_PREFIX = "drawable://";
    public static final String ASSET_PREFIX = "assets://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img);
        ;
        imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);


    }

    public void setFrames(View view) {
//        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 1000);
//        Bitmap circularBitmap = ImageConverter.getCirculerBitmap(bitmap);
//        Bitmap circularBitmap = ImageConverter.drawTriangle(bitmap,200,200,200);
//        Bitmap circularBitmap = ImageConverter.getTriangleBitmap(bitmap,400);
//        Bitmap circularBitmap = ImageConverter.getHeartBitmap(bitmap);
        Bitmap circularBitmap = ImageConverter.pentagon(bitmap);
        imageView.setImageBitmap(circularBitmap);

    }

    public void showTriangle(View view) {
//        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 1000);
//        Bitmap circularBitmap = ImageConverter.getCirculerBitmap(bitmap);
        Bitmap circularBitmap = ImageConverter.getTriangleBitmap(bitmap, 200);
//        Bitmap circularBitmap = ImageConverter.getTriangleBitmap(bitmap,400);
//        Bitmap circularBitmap = ImageConverter.getHeartBitmap(bitmap);
        imageView.setImageBitmap(circularBitmap);
    }

    public void showReverseTriangle(View view) {
        Bitmap circularBitmap = ImageConverter.getReverseTriangleBitmap(bitmap);
        imageView.setImageBitmap(circularBitmap);

    }

    public void circleShape(View view) {
        Bitmap circularBitmap = ImageConverter.getCirculerBitmap(bitmap);
        imageView.setImageBitmap(circularBitmap);


    }

    public void showhombus(View view) {
        Bitmap circularBitmap = ImageConverter.rhombus(bitmap);
        imageView.setImageBitmap(circularBitmap);

    }

    public void roundCorner(View view) {
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap,70);
        imageView.setImageBitmap(circularBitmap);
    }

    public void heart(View view) {
        Bitmap circularBitmap = ImageConverter.getHeartBitmap(bitmap);
        imageView.setImageBitmap(circularBitmap);
    }

    public void getStar4(View view) {
        Bitmap circularBitmap = ImageConverter.getStar(bitmap,4);
        imageView.setImageBitmap(circularBitmap);


    }


    public void getStart50(View view) {
        Bitmap circularBitmap = ImageConverter.getStar(bitmap,50);
        imageView.setImageBitmap(circularBitmap);

    }

    public void getStart8(View view) {
        Bitmap circularBitmap = ImageConverter.getStar(bitmap,8);
        imageView.setImageBitmap(circularBitmap);

    }

   }
