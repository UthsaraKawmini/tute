package com.example.tute;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST = 1888;
    ImageView ImageView ;
    Button photoButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ImageView= (ImageView) this.findViewById(R.id.displayImageView);
        Button photoButton = (Button) this.findViewById(R.id.Cam);

        photoButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

        @Override
            protected void onActivityResult(int requestCode,int resultCode,Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_REQUEST) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                ImageView.setImageBitmap(photo);
            }

        }

    }


