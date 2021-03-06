package com.example.intenty;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/*
Tato aktivita bude otevírána aktivitou SumActivity, od které bude přijímat dvě čísla. Úkolem této
aktivity bude tato dvě čísla sečíst a zobrazit výsledek. Stisknutím tlačítka "Odeslat součet" bude
tento výsledek odeslán zpět do aktivity SumActivity.
*/
public class SumResultActivity extends AppCompatActivity {

    TextView labelNumber1;      // Zobrazení prvního příchozího čísla
    TextView labelNumber2;      // Zobrazení druhého příchozího čísla
    TextView labelResult;       // Zobrazení výsledku součtu příchozích čísel
    Button btnSend;             // Tlačítko pro odeslání odpovědi do aktivity SumActivity

    int number1 = 0;
    int number2 = 0;

    // Deklarace listeneru pro odchycení události stisku tlačítka pro odeslání.
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Podle id stisknuté komponenty zjistíme co bylo stisknuto. Referenci na stisknutou
            // komponentu získáme v parametru metody onClick(View v).
            if (v.getId() == R.id.btnSend) {
                // Vytvoření intentu, který zde slouží pouze jako kontejner dat pro SumActivity
                Intent resultIntent = new Intent();

                // Přidání dat do intentu -> výsledek součtu přijatých čísel. Je použit klíč
                // "result_from_activity_sum", díky kterému si tato data vyzvedneme v SumActivity
                resultIntent.putExtra("result_from_activity_sum", number1 + number2);

                // Nastavení výsledku z této aktivity pro aktivitu, ze které byla tato
                // aktivita otevřena. Typ tohoto výsledku rozlišujeme v aktivitě SumActivity
                // v metodě onActivityResult().
                setResult(RESULT_OK, resultIntent);

                // Zavření této aktivity a návrat do SumActivity
                finish();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Nastavení připraveného XML návrhu grafického uživatelského rozhraní této aktivitě
        setContentView(R.layout.sum_result_activity);

        // Nastavení textu toolbaru
        setTitle(R.string.sum_result_activity_title);

        // Reference na komponenty v XML návrhu
        labelNumber1 = findViewById(R.id.labelNumber1);
        labelNumber2 = findViewById(R.id.labelNumber2);
        labelResult = findViewById(R.id.labelResult);
        btnSend = findViewById(R.id.btnSend);

        // Tlačítku pro odeslání odpovědi nastavíme dříve deklarovaný listener onClick()
        btnSend.setOnClickListener(clickListener);

        try {
            // Získání příchozího intentu, kterým byla tato aktivita otevřena.
            Intent incomingIntent = getIntent();

            number1 = incomingIntent.getIntExtra("number_1", 0);
            number2 = incomingIntent.getIntExtra("number_2", 0);

            labelNumber1.setText("" + number1);
            labelNumber2.setText("" + number2);
            labelResult.setText("" + (number1 + number2));
        } catch (NullPointerException e) {
            // Ošetření výjimky na NullPointerException je zde proto, že incomingIntent může být NULL.
            // Pokud by byl incomingIntent NULL, došlo by k pádu aplikace za běhu.
            labelNumber1.setText("?");
            labelNumber2.setText("?");

            Toast.makeText(this, R.string.incoming_intent_data_error, Toast.LENGTH_LONG).show();
        }
    }
}
