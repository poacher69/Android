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

public class LightActivity extends Activity {

    private Context context;
    private TextView textViewLight;
    private ImageView imageViewLight;
    private SensorManager sensorManager;
    private MyListener listener;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        context = this;

        setTitle("Light Sensor");

        textViewLight = (TextView) findViewById(R.id.textView_light);
        imageViewLight = (ImageView) findViewById(R.id.imageView_light);
        textViewLight.setText("");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        listener = new MyListener();
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_FASTEST);


    }//end of onCreate()


    private class MyListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {

            StringBuilder sb = new StringBuilder();
            sb.append("Sensor: "+event.sensor.getName()+"\n");
            float lightValue = event.values[0];
            sb.append("Light value: "+lightValue+"lux\n");

            if(lightValue < 20) {
                textViewLight.setText(sb.toString() + "Too close !!");
                imageViewLight.setImageResource(R.drawable.dark_light);
            }else {

                textViewLight.setText(sb.toString());
                imageViewLight.setImageResource(R.drawable.imageslight);

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

}//end of LightActivity()
