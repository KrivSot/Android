package com.example.hra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    SharedPreferences spref;
    private static String TOP_SCORE = "topSkore";
    int skore;
    int randomCislo;
    int cislo;
    int pocetpokusu = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.TextViewSkore);
        spref = getPreferences(MODE_PRIVATE);
        tv.setText(spref.getInt(TOP_SCORE,0));
        RandomCislo();
    }

    public void Click()
    {
        TextView odpoved = findViewById(R.id.OdpovedET); TextView pokus = findViewById(R.id.textViewPP); TextView skor = findViewById(R.id.TextViewSkore);
        this.cislo = Integer.parseInt(odpoved.getText().toString());
        if(this.cislo == this.randomCislo) {
            this.skore++;
            skor.setText(this.skore);
            //Ulozeni skore
            SharedPreferences.Editor editor = spref.edit();
            editor.putInt(TOP_SCORE,skore);
            editor.commit();
            Toast.makeText(getApplicationContext(),"Uhodnul si správně číslo.", Toast.LENGTH_SHORT);
            RandomCislo();
        }
        else {
            Toast.makeText(getApplicationContext(),"Neuhodnul si správně číslo!", Toast.LENGTH_SHORT);
            this.pocetpokusu--;
            pokus.setText(this.pocetpokusu); //odečte pokus
        }
    }

    public int RandomCislo()
    {
        Random r = new Random();
        this.randomCislo = r.nextInt(10-1)+1;
        return this.randomCislo;
    }
}