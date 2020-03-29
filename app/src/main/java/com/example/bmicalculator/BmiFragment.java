package com.example.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BmiFragment extends Fragment {

    private EditText waga, wzrost;
    private TextView wynik;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        waga = view.findViewById(R.id.waga);
        wzrost = view.findViewById(R.id.wzrost);
        wynik = view.findViewById(R.id.wynik);
        Button oblicz = view.findViewById(R.id.oblicz);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obliczBMI();
            }
        });
        return view;
    }

    private void obliczBMI() {

        String S1 = waga.getText().toString();
        String S2 = wzrost.getText().toString();

        float wagaValue = Float.parseFloat(S1);
        float wzrostValue = Float.parseFloat(S2) / 100;

        float bmi = wagaValue / (wzrostValue * wzrostValue);
        bmi = Math.round(bmi);

        printBMI(bmi);
    }

    private void printBMI(float bmi) {

        String wynikBMI;

        if(bmi < 16) {
            wynikBMI = "Wygłodzenie";
        } else if(bmi >= 16 && bmi < 17) {
            wynikBMI = "Wychudzenie";
        } else if(bmi >= 17 && bmi < 18.5) {
            wynikBMI = "Niedowaga";
        } else if(bmi >= 18.5 && bmi < 25) {
            wynikBMI = "Waga prawidłowa";
        } else if(bmi >= 25 && bmi < 30) {
            wynikBMI = "Nadwaga";
        } else if(bmi >= 30 && bmi < 35) {
            wynikBMI = "Otyłość I stopnia";
        } else if(bmi >= 35 && bmi < 40) {
            wynikBMI = "Otyłość II stopnia";
        } else {
            wynikBMI = "Otyłość III stopnia";
        }

        String obliczenia = bmi + "\n" + wynikBMI;

        wynik.setText(obliczenia);
    }
}
