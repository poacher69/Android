package com.poacher.sensor_control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.poacher.ACCActivity;
import com.poacher.LightActivity;
import com.poacher.ProximityActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Context context;
    private Switch sensorSwitch;
    private ListView sensorListView;
    private SensorManager sensorManager;
    private List<Sensor> sensorList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        sensorSwitch = (Switch) findViewById(R.id.switch_id);
        sensorListView = (ListView) findViewById(R.id.listView_id);

        sensorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                    sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

                    List<String> sensorNameList = new ArrayList<>();
                    for(Sensor sensor: sensorList){

                        String message = sensor.getType()+" - "+sensor.getName() + ": "+sensor.getPower()+
                                         "mA\n"+sensor.getVendor();
                        sensorNameList.add(message);
                    }

                    adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, sensorNameList);
                    sensorListView.setAdapter(adapter);

                    setTitle("Sensor number: "+sensorNameList.size());
                    sensorListView.setOnItemClickListener(new itemOnClick());

                } else {

                    adapter.clear();
                    adapter.notifyDataSetChanged();
                    setTitle("Sensor List");

                }
            }
        });


    }//end of onCreate()


    private class itemOnClick implements android.widget.AdapterView.OnItemClickListener {
        private Sensor sensor;
        private Intent intent;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Sensor sensorItem = sensorList.get(position);

            int sensorId = sensorItem.getType();

            switch(sensorId){

                case Sensor.TYPE_PROXIMITY:
                    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                    if(sensor == null){
                        Toast.makeText(context, "No Proximity Sensor", Toast.LENGTH_SHORT).show();
                    } else {
                        intent = new Intent(context, ProximityActivity.class);
                        startActivity(intent);

                    }

                    break;

                case Sensor.TYPE_LIGHT:
                    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
                    if(sensor == null){
                        Toast.makeText(context, "No Light Sensor", Toast.LENGTH_SHORT).show();
                    } else {
                        intent = new Intent(context, LightActivity.class);
                        startActivity(intent);

                    }

                    break;

                case Sensor.TYPE_ACCELEROMETER:
                    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                    if(sensor == null){
                        Toast.makeText(context, "No Accelerometer Sensor", Toast.LENGTH_SHORT).show();
                    } else {
                        intent = new Intent(context, ACCActivity.class);
                        startActivity(intent);

                    }



                    break;

                default:

                    Toast.makeText(context, "Program does not support this sensor.", Toast.LENGTH_SHORT).show();
                    break;
            }//end of switch()



        }//end of itemOnClick.classOverride()


    }//end of itemOnClick.class()


}//end of MainActivity()
