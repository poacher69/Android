package com.julia.widgetanim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends Activity {

    private static final String TAG ="display" ;
    private ImageView image;
    private TextView textDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        image = (ImageView) findViewById(R.id.imageView_display);
        textDisplay = (TextView) findViewById(R.id.textView_display);

        Intent intent = getIntent();
        String name = intent.getStringExtra("title");
        setTitle(name);
        Log.d(TAG,"Title = "+name);

        int imageID = intent.getIntExtra("imageID",0);
        int stringID = intent.getIntExtra("stringID",0);
//        image.setScaleType(ImageView.ScaleType.CENTER);
        image.setImageResource(imageID);
        String temp = getResources().getString(stringID);
        textDisplay.setText(temp);

    }
}
