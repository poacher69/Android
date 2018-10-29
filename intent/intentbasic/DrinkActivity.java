package com.julia.intentbasic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DrinkActivity extends Activity {

    private TextView text;
    private Button buttonBack, buttonNext;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        context = this;

        setTitle("Drink Menu");

        text = (TextView) findViewById(R.id.textView_drink);
        text.setTextSize(20);
        text.setTextColor(0xff008080);
        text.setText("The drink menu is under constructed.");

        buttonBack = (Button) findViewById(R.id.button_back);
        buttonNext = (Button) findViewById(R.id.button_next);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainCouseActivity.class);
                startActivity(intent);
            }
        });


    }
}
