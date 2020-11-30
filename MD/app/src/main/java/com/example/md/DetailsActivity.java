package com.example.md;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        if(savedInstanceState == null){
            DetailFragment details = new DetailFragment();

            details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content,details);

        }
    }
}
