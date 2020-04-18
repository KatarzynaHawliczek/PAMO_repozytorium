//package com.example.bmicalculator.javaclasses;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.example.bmicalculator.R;
//
//public class JCaloriesFragment extends Fragment implements AdapterView.OnItemSelectedListener {
//
//    private String plecTxt;
//    private EditText waga;
//    private EditText wzrost;
//    private EditText wiek;
//    private TextView wynik;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_calories, container, false);
//
//        waga = view.findViewById(R.id.waga);
//        wzrost = view.findViewById(R.id.wzrost);
//        wiek = view.findViewById(R.id.wiek);
//        wynik = view.findViewById(R.id.wynik);
//        Spinner plec = view.findViewById(R.id.plec);
//
//        ArrayAdapter<CharSequence> adapter;
//        adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.plecList, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        plec.setAdapter(adapter);
//        plec.setOnItemSelectedListener(this);
//
//        Button oblicz = view.findViewById(R.id.oblicz);
//        oblicz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                obliczPPM();
//            }
//        });
//        return view;
//    }
//
//    private void obliczPPM() {
//
//        String S1 = waga.getText().toString();
//        String S2 = wzrost.getText().toString();
//        String S3 = wiek.getText().toString();
//        String pl = getString(R.string.plecK);
//
//        double wagaValue = Double.parseDouble(S1);
//        double wzrostValue = Double.parseDouble(S2);
//        double wiekValue = Double.parseDouble(S3);
//        double ppm;
//
//        if(plecTxt.equals(pl)) {
//            ppm = 655.1 + (9.567 * wagaValue) + (1.85 * wzrostValue) - (4.68 * wiekValue);
//        } else {
//            ppm = 66.47 + (13.7 * wagaValue) + (5.0 * wzrostValue) - (6.76 * wiekValue);
//        }
//
//        ppm = Math.round(ppm);
//        String kalorie = ppm + " kcal";
//        wynik.setText(kalorie);
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        plecTxt = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), plecTxt, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}
