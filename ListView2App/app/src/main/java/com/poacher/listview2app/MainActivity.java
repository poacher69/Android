package com.poacher.listview2app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private Context context;
    private ListView listView1;
    private SimpleAdapter adapter;
    private String clickMessage;
    private int foodIndex;
//    private ArrayAdapter<CharSequence>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        listView1 = (ListView) findViewById(R.id.listView_id);

        Map<String, Object> hamburger = new HashMap<>();
        hamburger.put("name","Hamburger");
        hamburger.put("price","$120");
        hamburger.put("image",R.drawable.hamburger);

        Map<String, Object> frenchFries = new HashMap<>();
        frenchFries.put("name", "French Fries");
        frenchFries.put("price", "$60");
        frenchFries.put("image", R.drawable.french_fries);

        Map<String, Object> coca = new HashMap<>();
        coca.put("name", "Coca");
        coca.put("price", "$40");
        coca.put("image", R.drawable.coca_cola);

        Map<String, Object> colaLight = new HashMap<>();
        colaLight.put("name", "Cola Light");
        colaLight.put("price", "$35");
        colaLight.put("image", R.drawable.coca_cola_light);

        Map<String, Object> colaZero = new HashMap<>();
        colaZero.put("name", "Cola Zero");
        colaZero.put("price", "$40");
        colaZero.put("image", R.drawable.coca_cola_zero);

        Map<String, Object> kfc = new HashMap<>();
        kfc.put("name", "KFC Family Set");
        kfc.put("price", "$499");
        kfc.put("image", R.drawable.kfc);

        List<Map<String, Object>> itemList = new ArrayList<>();
        itemList.add(hamburger);
        itemList.add(frenchFries);
        itemList.add(coca);
        itemList.add(colaLight);
        itemList.add(colaZero);
        itemList.add(kfc);


        adapter = new SimpleAdapter(context, itemList, R.layout.item_layout, new String[]{"name", "price", "image"},
                                     new int[]{R.id.textView_name, R.id.textView_price, R.id.imageView_image});

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> item = (HashMap<String,Object>) parent.getItemAtPosition(position);
                String msg = item.get("name") +":" +item.get("price");
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();


            }
        });


    } //end of onCreate()


} //end of MainActivity()
