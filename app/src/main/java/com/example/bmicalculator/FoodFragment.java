package com.example.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FoodFragment extends Fragment {

    private EditText bmi;
    private ListView produkty;
    private TextView potrawa, przepis;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food, container, false);

        bmi = view.findViewById(R.id.bmi);
        Button co_zjesc = view.findViewById(R.id.co_zjesc);
        potrawa = view.findViewById(R.id.potrawa);
        przepis = view.findViewById(R.id.przepis);
        produkty = view.findViewById(R.id.produkty);

        co_zjesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokazPrzepis();
            }
        });

        return view;
    }

    private void pokazPrzepis() {

        String S1 = bmi.getText().toString();
        float bmiValue = 0;

        if(!S1.isEmpty()) {
            bmiValue = Float.parseFloat(S1);
        } else {
            potrawa.setText(R.string.uwaga);
            przepis.setText("");
            String[] produktyLista = {""};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, produktyLista);
            produkty.setAdapter(adapter);
        }


        if(bmiValue > 0 && bmiValue < 18.5) {
            potrawa.setText(R.string.potrawa1);
            przepis.setText(R.string.przepis1);
            String[] produktyLista = getResources().getStringArray(R.array.produktyList1);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, produktyLista);
            produkty.setAdapter(adapter);
        } else if(bmiValue >= 18.5 && bmiValue <= 25) {
            potrawa.setText(R.string.potrawa2);
            przepis.setText(R.string.przepis2);
            String[] produktyLista = getResources().getStringArray(R.array.produktyList2);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, produktyLista);
            produkty.setAdapter(adapter);
        } else if(bmiValue > 25) {
            potrawa.setText(R.string.potrawa3);
            przepis.setText(R.string.przepis3);
            String[] produktyLista = getResources().getStringArray(R.array.produktyList3);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, produktyLista);
            produkty.setAdapter(adapter);
        }
    }
}
