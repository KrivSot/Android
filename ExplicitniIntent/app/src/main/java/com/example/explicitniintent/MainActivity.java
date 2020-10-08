package com.example.explicitniintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DruhaAktivita(View v){
        EditText et = findViewById(R.id.editTextTextPersonName);
        Intent i = new Intent(this,druha.class);
        i.putExtra("Va",et.getText().toString());
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        TextView tv = findViewById(R.id.textView2);
        String jm = data.getStringExtra("jmeno");
        tv.setText(jm);
    }
}