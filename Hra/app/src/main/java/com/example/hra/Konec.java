package com.example.hra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Konec extends AppCompatActivity {

    int maxskore;
    boolean SVNM; //jestli je skore vetsi nez maximalni skore
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konec);
        Button bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(clickListener);
        Button bt3 = findViewById(R.id.button3);
        bt3.setOnClickListener(clickListener);

        Intent skore = getIntent();
        int skor = skore.getIntExtra("Skore",0);
        maxskore = skore.getIntExtra("TopSkore",0);
        TextView tv = findViewById(R.id.textView4);
        if(maxskore < skor){
            SVNM = true;
            tv.setText("Gratuluji. Podařilo se ti překonat nejvyšší skóre");
        }
        else{
            SVNM = false;
            EditText et = findViewById(R.id.JmenoEditText);
            TextView tv2 = findViewById(R.id.textView5);
            Button bt1 = findViewById(R.id.button2);
            Button b2 = findViewById(R.id.button3);
            bt1.setText("Restartovat");
            b2.setText("Ukončit");
            et.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            tv.setText("Nepodařilo se ti překonat nejvyšší skóre.");

        }
    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText jmeno = findViewById(R.id.JmenoEditText);
            Intent zpet = new Intent();

                if (SVNM) {
                    if(!String.valueOf(jmeno.getText()).isEmpty()) {
                        if (view.getId() == R.id.button2) {
                            jmeno = findViewById(R.id.JmenoEditText);
                            zpet.putExtra("Konec", false);
                            zpet.putExtra("j", String.valueOf(jmeno.getText()));
                            setResult(RESULT_OK, zpet);
                            finish();
                        } else {
                            jmeno = findViewById(R.id.JmenoEditText);
                            zpet.putExtra("Konec", true);
                            zpet.putExtra("j", String.valueOf(jmeno.getText()));
                            setResult(RESULT_OK, zpet);
                            finish();
                        }
                    }
                    else{
                        error();
                    }
                } else {
                    if (view.getId() == R.id.button2) {
                        zpet.putExtra("Konec", false);
                        setResult(RESULT_CANCELED, zpet);
                        finish();
                    } else {
                        zpet.putExtra("Konec", true);
                        setResult(RESULT_CANCELED, zpet);
                        finish();
                    }
                }
    }
};
    public void error(){
        Toast.makeText(this.getApplicationContext(), "Nezadal si své jméno", Toast.LENGTH_SHORT).show();
    }
}