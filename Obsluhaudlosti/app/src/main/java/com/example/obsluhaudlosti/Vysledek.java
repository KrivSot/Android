package com.example.obsluhaudlosti;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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

    double BMI;
    @SuppressLint("SetTextI18n")
    public void Vysledek(Bundle ext)
    {
        TextView vt = findViewById(R.id.VyskaText);TextView ht = findViewById(R.id.HmotnostText);
        TextView bmit = findViewById(R.id.BMIText);
        TextView zr = findViewById(R.id.ZRText);
        if(ext !=null)
        {
            this.Vyska = ext.getDouble("paramVyska");
            this.Hmotnost= ext.getDouble("paramHmotnost");
            vt.setText(String.valueOf(Vyska));
            ht.setText(String.valueOf(Hmotnost));
            BMI = Hmotnost/(Vyska*Vyska);
            BMI = Math.round(BMI * 100.0) / 100.0;
            switch(BMIVysledek(BMI))
            {
                case "u":    bmit.setText(BMI+": Podváha."); zr.setText("Vysoké zdravotní riziko.");
                             bmit.setTextColor(Color.BLUE);
                             zr.setTextColor(Color.BLUE);break;
                case "n":    bmit.setText(BMI+": Normální váha."); zr.setText("Minimální zdravotní riziko.");
                             bmit.setTextColor(Color.GREEN);
                             zr.setTextColor(Color.GREEN);break;
                case "ov":   bmit.setText(BMI+": Nadváha."); zr.setText("Nízké až lehce vyšší zdravotní riziko.");
                             bmit.setTextColor(Color.parseColor("#FF9200"));
                             zr.setTextColor(Color.parseColor("#FF9200"));break;
                case "ob1":  bmit.setText(BMI+": Obezita 1. stupně."); zr.setText("Zvýšené zdravotní riziko.");
                             bmit.setTextColor(Color.parseColor("#FF6700"));
                             zr.setTextColor(Color.parseColor("#FF6700"));break;
                case "ob2":  bmit.setText(BMI+": Obezita 2. stupně."); zr.setText("Vysoké zdravotní riziko.");
                             bmit.setTextColor(Color.parseColor("#FF4800"));
                             zr.setTextColor(Color.parseColor("#FF4800"));break;
                case "ob3":  bmit.setText(BMI+": Obezita 3. stupně."); zr.setText("Velmi vysoké zdravotní riziko.");
                             bmit.setTextColor(Color.parseColor("#FF0000"));
                             zr.setTextColor(Color.parseColor("#FF0000"));break;
                default: error();
            }
        }
        else { error(); }
    }

    public void error()
    {
        String error = "Někde se stala chyba.";
        Toast.makeText(this,error, Toast.LENGTH_LONG).show();
    }

    String BMIVysledek(double BMI){
        if(BMI <=18.5){ return "u";}
        else if(BMI <=24.9){return "n";}
        else if(BMI <=29.9){return "ov";}
        else if(BMI <=34.9){return "ob1";}
        else if(BMI <=39.9){return "ob2";}
        else if(BMI >=40){return "ob3";}
        else{ return "nic";}
    }
}