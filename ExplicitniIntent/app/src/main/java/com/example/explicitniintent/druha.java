package com.example.explicitniintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class druha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druha);

        Intent intentprvniAktivity = getIntent();
        String coPoslalaPrvni = intentprvniAktivity.getExtras().getString("Va");
        TextView tv1 = findViewById(R.id.textViewP);
        tv1.setText(coPoslalaPrvni);
    }

    public void odesliJmeno(View v)
    {
        EditText et1 = (EditText)findViewById(R.id.editTextText);
        String jmeno = String.valueOf(et1.getText());
        Intent navrat = new Intent();
        navrat.putExtra("jmeno",jmeno);
        setResult(RESULT_OK,navrat);
        finish();
    }
}
