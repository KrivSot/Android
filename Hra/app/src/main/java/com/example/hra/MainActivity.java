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

    TextView tv;TextView pp;
    SharedPreferences spref;
    private static String TOP_SCORE = "topSkore";
    int skore;
    int maxskore;
    int randomCislo;
    int cislo;
    int pocetpokusu = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnReset();
    }

    public void Click(View view)
    {
        if(pocetpokusu !=0) {
            TextView odpoved = (TextView)findViewById(R.id.OdpovedET);
            TextView pokus = (TextView)findViewById(R.id.textViewPP);
            TextView maxskor = (TextView)findViewById(R.id.TextViewSkore);
            TextView skor = findViewById(R.id.textSC);
            this.cislo = Integer.parseInt(odpoved.getText().toString());
            if (this.cislo == this.randomCislo) {
                this.skore++;
                skor.setText(String.valueOf(this.skore));
                Toast.makeText(this.getApplicationContext(), "Uhodnul si správně číslo.", Toast.LENGTH_SHORT).show();
                //Ulozeni skore
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
                pokus.setText(String.valueOf(this.pocetpokusu)); //odečte pokus
            }
        }
        else {
            Intent konechry = new Intent(MainActivity.this, Konec.class);
            konechry.putExtra("Skore",this.skore);
            startActivity(konechry);
        }
    }

    public void Skore(View view){
        Intent skore = new Intent(MainActivity.this,skore.class);
        startActivity(skore);
    }

    public void reset()
    {
        this.skore = 0;
        this.pocetpokusu = 10;
        OnReset();
    }

    public void OnReset(){
        spref = getPreferences(MODE_PRIVATE);
        maxskore = spref.getInt(TOP_SCORE,0);
        tv = findViewById(R.id.TextViewSkore);
        pp = findViewById(R.id.textViewPP);
        pp.setText(String.valueOf(pocetpokusu));
        tv.setText(String.valueOf(spref.getInt(TOP_SCORE,0)));
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
        reset();
    }
}