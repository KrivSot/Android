package com.example.obsluhaudlosti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Vysledek extends AppCompatActivity {
    double Hmotnost;
    double Vyska;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vysledek);
        Bundle extras = getIntent().getExtras();
        Vysledek(extras);
    }

    public void Vysledek(Bundle ext)
    {
        TextView vt = findViewById(R.id.VyskaText);
        TextView ht = findViewById(R.id.HmotnostText);
        if(ext !=null)
        {
            this.Vyska = ext.getDouble("paramVyska");
            this.Hmotnost= ext.getDouble("paramHmotnost");
            vt.setText(String.valueOf(Vyska));
            ht.setText(String.valueOf(Hmotnost));
        }
        else
        {
            System.out.println("nefunguje");
        }
    }
}