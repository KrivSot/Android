package com.example.hra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;TextView pp;TextView nh;
    TextView ts;
    SharedPreferences spref;
    private static String TOP_SCORE = "topSkore";
    private static String TOP_JMENO = "topJmeno";
    int skore;
    int maxskore;
    int randomCislo;
    int cislo;
    int pocetpokusu = 10;
    String nejhrac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset();
    }

    public void Click(View view)
    {
        if(pocetpokusu !=0) {
            TextView odpoved = findViewById(R.id.OdpovedET);
            TextView pokus = findViewById(R.id.textViewPP);
            TextView maxskor = findViewById(R.id.TextViewSkore);
            TextView skor = findViewById(R.id.textSC);
            if(odpoved.getText().toString().isEmpty())
            { this.cislo = 0; }
            else{ this.cislo = Integer.parseInt(odpoved.getText().toString()); }
            if (this.cislo == this.randomCislo) {
                this.skore++;
                skor.setText(String.valueOf(this.skore));
                Toast.makeText(this.getApplicationContext(), "Uhodnul si správně číslo.", Toast.LENGTH_SHORT).show();
                //Ulozeni skore
                odpoved.setText("");
                if(skore >= maxskore) {
                    maxskor.setText(String.valueOf(this.skore));
                    SharedPreferences.Editor editor = spref.edit();
                    editor.putInt(TOP_SCORE, skore);

                    editor.commit();
                }
                RandomCislo();
            } else {
                Toast.makeText(this.getApplicationContext(), "Neuhodnul si správně číslo!", Toast.LENGTH_SHORT).show();
                this.pocetpokusu--;
                odpoved.setText("");
                if(this.pocetpokusu == 0)
                {
                    Intent konechry = new Intent(MainActivity.this, Konec.class);
                    konechry.putExtra("Skore",this.skore);
                    konechry.putExtra("TopSkore",this.maxskore);
                    startActivityForResult(konechry,1);
                }
                else{
                    pokus.setText(String.valueOf(this.pocetpokusu)); //odečte pokus
                }
            }
        }
        else {
            Intent konechry = new Intent(MainActivity.this, Konec.class);
            konechry.putExtra("Skore",this.skore);
            startActivityForResult(konechry,1);
        }
    }

    public void Skore(View view){ //nefunkcni
        Intent skore = new Intent(MainActivity.this,skore.class);
        startActivity(skore);
    }

    public void reset()
    {
        this.skore = 0;
        this.pocetpokusu = 10;

        spref = getPreferences(MODE_PRIVATE);
        maxskore = spref.getInt(TOP_SCORE,0);
        nejhrac = spref.getString(TOP_JMENO,"neziskan");
        nh = findViewById(R.id.textViewNejHrac);
        tv = findViewById(R.id.TextViewSkore);
        ts = findViewById(R.id.textSC);
        ts.setText(String.valueOf(skore));
        pp = findViewById(R.id.textViewPP);
        pp.setText(String.valueOf(pocetpokusu));
        tv.setText(String.valueOf(spref.getInt(TOP_SCORE,0)));
        nh.setText(String.valueOf(nejhrac));
        RandomCislo();
    }

    public int RandomCislo()
    {
        Random r = new Random();
        this.randomCislo = r.nextInt(3-1)+1;
        return this.randomCislo;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(data.getBooleanExtra("Konec",true)){
                SharedPreferences.Editor editor = spref.edit();
                editor.putInt(TOP_SCORE, skore);
                editor.putString(TOP_JMENO,String.valueOf(data.getStringExtra("j")));

                editor.commit();
                this.finishAffinity();
            }
            else {
                SharedPreferences.Editor editor = spref.edit();
                nh = findViewById(R.id.textViewNejHrac);
                editor.clear();
                editor.putInt(TOP_SCORE, skore);
                editor.putString(TOP_JMENO, String.valueOf(data.getStringExtra("j")));

                editor.commit();
                reset();
            }
        }
        else{
            if(data.getBooleanExtra("Konec",true)){ this.finishAffinity(); }
            else{reset();}
        }
    }
}