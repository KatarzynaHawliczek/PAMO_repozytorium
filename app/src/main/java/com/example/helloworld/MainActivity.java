package com.example.helloworld;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

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

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Hello world!!!", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

//        return super.onOptionsItemSelected(item);
//    }
}
