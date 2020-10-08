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

    /*public void onClick(View v){
        EditText vstup = findViewById(R.id.NameText);
        String txt = vstup.getText().toString();
        if(txt.equals("") || txt.isEmpty())
        {
            txt = "Unhandled Exception: System.NullPointerException: Object reference at MainActivity.onClick()";
        }
        Toast.makeText(this,txt, Toast.LENGTH_LONG).show();
    }*/


    @SuppressLint("SetTextI18n")
    public void BMI(View v){
        Intent i = new Intent(this,Vysledek.class);
        double BMI; double vyskaD; double hmotnostD;
        EditText vyska = findViewById(R.id.NameText);
        EditText hmotnost = findViewById(R.id.HmotnostEditText);
        TextView bmit = findViewById(R.id.BMIText);
        TextView zr = findViewById(R.id.ZRText);
        String vsk = vyska.getText().toString();
        String h = hmotnost.getText().toString();

        if(isDecimal(vsk) && isDecimal(h))
        {
            vyskaD = Double.parseDouble(vsk);
            i.putExtra("paramVyska",vyskaD);
            hmotnostD = Double.parseDouble(h);
            i.putExtra("paramHmotnost",hmotnostD);
            startActivity(i);
            /*BMI = hmotnostD/(vyskaD*vyskaD);
            BMI = Math.round(BMI * 100.0) / 100.0;
            switch(BMIVysledek(BMI))
            {
                case "u": bmit.setText(BMI+": Podváha."); zr.setText("Vysoké zdravotní riziko.");
                            bmit.setTextColor(Color.BLUE);
                            zr.setTextColor(Color.BLUE);break;
                case "n": bmit.setText(BMI+": Normální váha."); zr.setText("Minimální zdravotní riziko.");
                            bmit.setTextColor(Color.GREEN);
                            zr.setTextColor(Color.GREEN);break;
                case "ov": bmit.setText(BMI+": Nadváha."); zr.setText("Nízké až lehce vyšší zdravotní riziko.");
                            bmit.setTextColor(Color.parseColor("#FF9200"));
                            zr.setTextColor(Color.parseColor("#FF9200"));break;
                case "ob1": bmit.setText(BMI+": Obezita 1. stupně."); zr.setText("Zvýšené zdravotní riziko.");
                            bmit.setTextColor(Color.parseColor("#FF6700"));
                            zr.setTextColor(Color.parseColor("#FF6700"));break;
                case "ob2": bmit.setText(BMI+": Obezita 2. stupně."); zr.setText("Vysoké zdravotní riziko.");
                            bmit.setTextColor(Color.parseColor("#FF4800"));
                            zr.setTextColor(Color.parseColor("#FF4800"));break;
                case "ob3": bmit.setText(BMI+": Obezita 3. stupně."); zr.setText("Velmi vysoké zdravotní riziko.");
                            bmit.setTextColor(Color.parseColor("#FF0000"));
                            zr.setTextColor(Color.parseColor("#FF0000"));break;
                default: error();
            }*/
        }
        else{
            error();
        }
    }

    public void Reset(View v)
    {
        EditText vyska = findViewById(R.id.NameText);
        vyska.setText("");
        EditText hmotnost = findViewById(R.id.HmotnostEditText);
        hmotnost.setText("");
        TextView bmit = findViewById(R.id.BMIText);
        bmit.setText("");
        TextView zr = findViewById(R.id.ZRText);
        zr.setText("");
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