package com.julia.intentbasic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int IntentRequestCode = 2;
    private static final int ReturnData = 1;
    private static final int ReturnError = 2;
    private Context context;
    private ImageButton drinkButton, mainButton;
    private Intent intent;
    private TextView orderResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        drinkButton = (ImageButton) findViewById(R.id.imageButton_drink);
        mainButton = (ImageButton) findViewById(R.id.imageButton_main);

        orderResult = (TextView) findViewById(R.id.textView_list);
        orderResult.setTextSize(20);
        orderResult.setTextColor(0xff008080);
        orderResult.setText("");

        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"order drink",Toast.LENGTH_SHORT).show();
                intent = new Intent(context, DrinkActivity.class);
                startActivity(intent);
            }
        });

//        mainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"order main course",Toast.LENGTH_SHORT).show();
//                intent = new Intent(context, MainCouseActivity.class);
//                startActivity(intent);
//            }
//        });
        
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, MainCouseActivity.class);
                startActivityForResult(intent, IntentRequestCode);
            }
        });

    } // end of onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IntentRequestCode){
            switch (resultCode){
                case ReturnData:

                    break;

                case ReturnError:

                    break;

                default:

                    break;

            }
        } // end of if
    }
}
