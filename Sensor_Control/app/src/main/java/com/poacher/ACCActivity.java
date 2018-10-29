package com.poacher;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.poacher.sensor_control.R;

public class ACCActivity extends Activity {

    private Context context;
    private TextView textViewACC;
    private ImageView imageViewTop, imageViewRight, imageViewLeft, imageViewDown;
    private ImageButton imageButtonStop;
    private SensorManager senorManager;
    private Sensor snesor;
    private MyListener listener;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        context = this;

        setTitle("Accelerometer Sensor");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textViewACC = (TextView) findViewById(R.id.textView_acc);
        textViewACC.setText("");

        imageViewTop = (ImageView) findViewById(R.id.imageView_top);
        imageViewDown = (ImageView) findViewById(R.id.imageView_down);
        imageViewRight = (ImageView) findViewById(R.id.imageView_right);
        imageViewLeft = (ImageView) findViewById(R.id.imageView_left);
        imageViewTop.setVisibility(View.INVISIBLE);
        imageViewRight.setVisibility(View.INVISIBLE);
        imageViewLeft.setVisibility(View.INVISIBLE);
        imageViewDown.setVisibility(View.INVISIBLE);

        imageButtonStop = (ImageButton) findViewById(R.id.imageButton_stop);
        imageButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Stop Button", Toast.LENGTH_SHORT).show();
            }
        });

        senorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        snesor = senorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new MyListener();
        senorManager.registerListener(listener, snesor, SensorManager.SENSOR_DELAY_UI);



    }//end of onCreate()


    private class MyListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {

            StringBuilder sb = new StringBuilder();
            sb.append("Sensor: "+event.sensor.getName()+"\n");
            sb.append("values:\n");

            float X_Value = event.values[0];
            float Y_Value = event.values[1];
            float Z_Value = event.values[2];

            sb.append("X = "+Float.toString(X_Value)+"\n");
            sb.append("Y = "+Float.toString(Y_Value)+"\n");
            sb.append("Z = "+Float.toString(Z_Value)+"\n");

            textViewACC.setText(sb.toString());


            if(X_Value < -2.0) {
                imageViewTop.setVisibility(View.INVISIBLE);
                imageViewLeft.setVisibility(View.INVISIBLE);
                imageViewRight.setVisibility(View.VISIBLE);
                imageViewDown.setVisibility(View.INVISIBLE);
                
            } else if(X_Value >2.0){
                imageViewTop.setVisibility(View.INVISIBLE);
                imageViewLeft.setVisibility(View.VISIBLE);
                imageViewRight.setVisibility(View.INVISIBLE);
                imageViewDown.setVisibility(View.INVISIBLE);
                
            }
            else {

                if (Z_Value > 5) {
                    imageViewTop.setVisibility(View.VISIBLE);
                    imageViewLeft.setVisibility(View.INVISIBLE);
                    imageViewRight.setVisibility(View.INVISIBLE);
                    imageViewDown.setVisibility(View.INVISIBLE);

                } else if (Z_Value < 0) {
                    imageViewTop.setVisibility(View.INVISIBLE);
                    imageViewLeft.setVisibility(View.INVISIBLE);
                    imageViewRight.setVisibility(View.INVISIBLE);
                    imageViewDown.setVisibility(View.VISIBLE);


                } else {
                    imageViewTop.setVisibility(View.INVISIBLE);
                    imageViewLeft.setVisibility(View.INVISIBLE);
                    imageViewRight.setVisibility(View.INVISIBLE);
                    imageViewDown.setVisibility(View.INVISIBLE);


                }

            }

        }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }
        @Override
        protected void onDestroy() {
            senorManager.unregisterListener(listener);
            super.onDestroy();
        }

}//end of ACCActivity()


