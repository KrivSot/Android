package com.example.md;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

public class kArrayAdapter extends AppCompatActivity {
    ArrayAdapter<kralove> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ArrayAdapter<kralove> GetKralove()
    {
        return this.adapter;
    }

    public void SetKralove(ArrayAdapter<kralove> kralove)
    {
        this.adapter = kralove;
    }


    public void Initialize()
    {
        List<kralove> kralove = null;
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            kralove = parser.parse(getAssets().open("data.xml"));
            adapter = new ArrayAdapter<kralove>(this, android.R.layout.simple_list_item_activated_1, kralove);
            SetKralove(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}