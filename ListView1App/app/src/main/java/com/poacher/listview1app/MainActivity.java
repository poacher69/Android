package com.poacher.listview1app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Context context;
    private Spinner spinner1;
    private ListView listView1;
    private ArrayAdapter<CharSequence> spinnerAdapter;
    private String cityMessage;
    private String[] food;
    private ArrayAdapter<String> listAdapter;
    private String foodMessage;
    private int foodIndex;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        spinner1 = (Spinner) findViewById(R.id.spinner_id);
        listView1 = (ListView) findViewById(R.id.listView_id);

//        spinnerAdapter = ArrayAdapter.createFromResource(context, R.array.city, android.R.layout.simple_spinner_item);
        spinnerAdapter = ArrayAdapter.createFromResource(context, R.array.city, R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerAdapter);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    cityMessage = parent.getItemAtPosition(position).toString();
                    Toast.makeText(context, cityMessage, Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            food = getResources().getStringArray(R.array.fastfood);

            listAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, food);
            listView1.setAdapter(listAdapter);
            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    foodMessage = parent.getItemAtPosition(position).toString();
                    Toast.makeText(context, foodMessage, Toast.LENGTH_SHORT).show();
                    foodIndex = position;
                    showDialog_1();


                }
            });




    } //end of onCreate()

    private void showDialog_1() {

        builder = new AlertDialog.Builder(context);
        builder.setTitle("Select food");
        builder.setMessage(foodMessage);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){

                Intent intent = new Intent(context, NewActivity.class);
                intent.putExtra("title", cityMessage);
                intent.putExtra("food", foodMessage);
                intent.putExtra("foodIndex", foodIndex);

                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    } //end of showDialog_1()


} //end of MainActivity()
