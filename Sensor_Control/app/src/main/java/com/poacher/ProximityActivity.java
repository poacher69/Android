package com.poacher;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.poacher.sensor_control.R;

public class ProximityActivity extends Activity {

    private Context context;
    private TextView textViewProx;
    private ImageView imageViewGirl;
    private SensorManager sensorManager;
    private MyListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        setTitle("Proximity Sensor");

        context = this;

        textViewProx = (TextView) findViewById(R.id.textView_proxid);
        imageViewGirl = (ImageView) findViewById(R.id.imageView_girl);
        textViewProx.setText("");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        listener = new MyListener();
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_FASTEST);



    }//end of onCreate()


    private class MyListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {

            StringBuilder sb = new StringBuilder();
            sb.append("Sensor: "+event.sensor.getName()+"\n");
            float proxValue = event.values[0];
            sb.append("Proximity value: "+proxValue+"cm\n");

            if(proxValue < 1){
                textViewProx.setText(sb.toString()+"Too close !!");
                imageViewGirl.setImageResource(R.drawable.p2);


            } else {

                textViewProx.setText(sb.toString());
                imageViewGirl.setImageResource(R.drawable.p1);

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    @Override
    protected void onDestroy() {
        sensorManager.unregisterListener(listener);
        super.onDestroy();
    }
}//end of ProximityActivity()
