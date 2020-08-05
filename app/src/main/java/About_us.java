package com.example.mask_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class About_us extends AppCompatActivity {

    private String[] names = new String[]{"Shivam Kumar", "Arjun Anand", "Reetvik Chatterjee", "Harit Yadav"};
    private String[] descriptions = new String[]{"", "", "", "", "", "", ""};
    private int[] images = new int[]{R.drawable.shivam, R.drawable.arjun, R.drawable.reetvik, R.drawable.eveator};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        listView = findViewById(R.id.listView);
        List<HashMap<String,String>> aList = new ArrayList<>();
        for (int x = 0; x < names.length; x++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("Name",names[x]);
            hm.put("",descriptions[x]);
            hm.put("Image",Integer.toString(images[x]));
            aList.add(hm);
        }
        String[] from = {"Image","Name"};
        int[] to = {R.id.image,R.id.name};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,aList, R.layout.contributors_row,from,to);
        listView.setAdapter(simpleAdapter);

    }
}