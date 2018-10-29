package com.poacher.listview1app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends Activity {

    private int[] foodPicture = {R.drawable.coca_cola_light, R.drawable.coca_cola_zero, R.drawable.coca_cola,
                                 R.drawable.french_fries, R.drawable.hamburger, R.drawable.kfc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String name = intent.getStringExtra("title");
        setTitle(name);

        TextView foodname = (TextView) findViewById(R.id.textView2_id);
        name = intent.getStringExtra("food");
        foodname.setText(name);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView_id);
        int index = intent.getIntExtra("foodIndex", 0);

        imageView1.setImageResource(foodPicture[index]);


    } // end of onCreate()


} //end of NewActivity()
