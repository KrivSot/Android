package com.example.intenty;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Fragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Configuration configInfo = getResources().getConfiguration();
        if(configInfo.orientation == Configuration.ORIENTATION_LANDSCAPE){
            FragmentLandscape fragmentlandscape = new FragmentLandscape();
            fragmentTransaction.replace(android.R.id.content,fragmentlandscape);
            fragmentTransaction.commit();
            setContentView(R.layout.fragment_lanscape);
        }
        else {
            FragmentPortrait fragmentportrait = new FragmentPortrait();
            fragmentTransaction.replace(android.R.id.content,fragmentportrait);
            fragmentTransaction.commit();
            setContentView(R.layout.fragment_portrait);
            }
    }
}
