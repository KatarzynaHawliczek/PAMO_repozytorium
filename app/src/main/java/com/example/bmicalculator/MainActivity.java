package com.example.bmicalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bmicalculator.R;

public class MainActivity extends AppCompatActivity {
    EditText waga, wzrost;
    TextView wynik;
    String obliczenia, wynikBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waga = findViewById(R.id.waga);
        wzrost = findViewById(R.id.wzrost);
        wynik = findViewById(R.id.wynik);
    }

    public void obliczBMI(View view) {
        String S1 = waga.getText().toString();
        String S2 = wzrost.getText().toString();

        float wagaValue = Float.parseFloat(S1);
        float wzrostValue = Float.parseFloat(S2) / 100;

        float bmi = wagaValue / (wzrostValue * wzrostValue);

        if(bmi < 16){
            wynikBMI = "Wygłodzenie";
        }else if(bmi >= 16 && bmi < 17){
            wynikBMI = "Wychudzenie";
        }else if(bmi >= 17 && bmi < 18.5){
            wynikBMI = "Niedowaga";
        }else if(bmi >= 18.5 && bmi < 25){
            wynikBMI = "Waga prawidłowa";
        }else if(bmi >= 25 && bmi < 30){
            wynikBMI = "Nadwaga";
        }else if(bmi >= 30 && bmi < 35){
            wynikBMI = "Otyłość I stopnia";
        }else if(bmi >= 35 && bmi < 40){
            wynikBMI = "Otyłość II stopnia";
        }else{
            wynikBMI = "Otyłość III stopnia";
        }

        obliczenia = "Wynik:\n\n" + bmi + "\n" + wynikBMI;

        wynik.setText(obliczenia);
    }
}
