package com.example.hra;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class skore extends AppCompatActivity {

    TextView tv;
    SharedPreferences spref;
    private static String TOP_SCORE = "topSkore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skore);

        Gson gson = new Gson();
        String jsonText = spref.getString("Jmeno", null);
        String[] text = gson.fromJson(jsonText, String[].class);
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for(int i = 0; i < text.length; i++)
        {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            TextView textViewj = new TextView(this); //text s jmenem
            TextView textViews = new TextView(this); //text se skorem
            textViewj.setText(text[i]);
            textViews.setText(spref.getInt(TOP_SCORE,0));
            ll.addView(textViewj);
            ll.addView(textViews);
            linearLayout.addView(ll);
        }
    }
}
