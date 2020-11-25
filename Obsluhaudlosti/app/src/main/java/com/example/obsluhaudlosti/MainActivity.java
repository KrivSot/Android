package com.example.obsluhaudlosti;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart(); //Your licence will soon expire. Please Renew it.
        Toast.makeText(this,"Aplikace se načetla.", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    public void BMI(View v){
        Intent i = new Intent(this,Vysledek.class);
        double vyskaD; double hmotnostD;
        EditText vyska = findViewById(R.id.NameText);
        EditText hmotnost = findViewById(R.id.HmotnostEditText);
        String vsk = vyska.getText().toString();
        String h = hmotnost.getText().toString();
        if(isDecimal(vsk) && isDecimal(h))
        {
            vyskaD = Double.parseDouble(vsk);
            i.putExtra("paramVyska",vyskaD);
            hmotnostD = Double.parseDouble(h);
            i.putExtra("paramHmotnost",hmotnostD);
            startActivity(i);
        }
        else{
            error();
        }
    }

    public void Reset(View v)
    {
        Intent i = new Intent(Intent.ACTION_CALL);
        /*EditText vyska = findViewById(R.id.NameText);
        vyska.setText("");
        EditText hmotnost = findViewById(R.id.HmotnostEditText);
        hmotnost.setText("");*/
    }

    public void error()
    {
        String error = "Jedna ze zadaných hodnot není správná!";
        Toast.makeText(this,error, Toast.LENGTH_LONG).show();
    }

    double amount;
    boolean isDecimal(String string) {
        try {
            this.amount = Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}