package com.example.panovnicicech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView1);
        List<Kralove> kralove = null;
        try{
            XMLPullParserHandler parser = new XMLPullParserHandler();
            kralove = parser.parse(getAssets().open("data.xml"));
            ArrayAdapter<Kralove> adapter = new ArrayAdapter<Kralove>(this,R.layout.support_simple_spinner_dropdown_item,kralove);
            listView.setAdapter(adapter);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}