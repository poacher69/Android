package com.julia.widgetanim;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "main";
    private ImageButton imageBtn1,imageBtn2,imageBtn3,imageBtn4,imageBtn5,imageBtn6;
    private ImageButton imageBtn7,imageBtn8,imageBtn9,imageBtn10;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        imageBtn1 = (ImageButton) findViewById(R.id.imageButton1);
        imageBtn2 = (ImageButton) findViewById(R.id.imageButton2);
        imageBtn3 = (ImageButton) findViewById(R.id.imageButton3);
        imageBtn4 = (ImageButton) findViewById(R.id.imageButton4);
        imageBtn5 = (ImageButton) findViewById(R.id.imageButton5);
        imageBtn6 = (ImageButton) findViewById(R.id.imageButton6);
        imageBtn7 = (ImageButton) findViewById(R.id.imageButton7);
        imageBtn8 = (ImageButton) findViewById(R.id.imageButton8);
        imageBtn9 = (ImageButton) findViewById(R.id.imageButton9);
        imageBtn10 = (ImageButton) findViewById(R.id.imageButton10);

        imageBtn1.setOnClickListener(new ImageBtnClick());
        imageBtn2.setOnClickListener(new ImageBtnClick());
        imageBtn3.setOnClickListener(new ImageBtnClick());
        imageBtn4.setOnClickListener(new ImageBtnClick());
        imageBtn5.setOnClickListener(new ImageBtnClick());
        imageBtn6.setOnClickListener(new ImageBtnClick());
        imageBtn7.setOnClickListener(new ImageBtnClick());
        imageBtn8.setOnClickListener(new ImageBtnClick());
        imageBtn9.setOnClickListener(new ImageBtnClick());
        imageBtn10.setOnClickListener(new ImageBtnClick());

    }

    private class ImageBtnClick implements View.OnClickListener {
        private String name;
        private ActivityOptions option;

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context,DisplayActivity.class);

            switch ( view.getId()) {

                case R.id.imageButton1:
                    name = getResources().getString(R.string.btn1);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_1);
                    intent.putExtra("stringID",R.string.btn1_info);
                    imageBtn1.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn1,name);

                    break;

                case R.id.imageButton2:
                    name = getResources().getString(R.string.btn2);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_2);
                    intent.putExtra("stringID",R.string.btn2_info);
                    imageBtn2.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn2,name);

                    break;

                case R.id.imageButton3:
                    name = getResources().getString(R.string.btn3);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_3);
                    intent.putExtra("stringID",R.string.btn3_info);
                    imageBtn3.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn3,name);

                    break;

                case R.id.imageButton4:
                    name = getResources().getString(R.string.btn4);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_4);
                    intent.putExtra("stringID",R.string.btn4_info);
                    imageBtn4.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn4,name);

                    break;

                case R.id.imageButton5:
                    name = getResources().getString(R.string.btn5);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_5);
                    intent.putExtra("stringID",R.string.btn5_info);
                    imageBtn5.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn5,name);

                    break;

                case R.id.imageButton6:
                    name = getResources().getString(R.string.btn6);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_6);
                    intent.putExtra("stringID",R.string.btn6_info);
                    imageBtn6.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn6,name);

                    break;

                case R.id.imageButton7:
                    name = getResources().getString(R.string.btn7);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_7);
                    intent.putExtra("stringID",R.string.btn7_info);
                    imageBtn7.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn7,name);

                    break;

                case R.id.imageButton8:
                    name = getResources().getString(R.string.btn8);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_8);
                    intent.putExtra("stringID",R.string.btn8_info);
                    imageBtn8.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn8,name);

                    break;

                case R.id.imageButton9:
                    name = getResources().getString(R.string.btn9);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_9);
                    intent.putExtra("stringID",R.string.btn9_info);
                    imageBtn9.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn9,name);

                    break;

                case R.id.imageButton10:
                    name = getResources().getString(R.string.btn10);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.img_10);
                    intent.putExtra("stringID",R.string.btn10_info);
                    imageBtn10.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageBtn10,name);

                    break;

            }
            startActivity(intent, option.toBundle());
        }
    }


}
