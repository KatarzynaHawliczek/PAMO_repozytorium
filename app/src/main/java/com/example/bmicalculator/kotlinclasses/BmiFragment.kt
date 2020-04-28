package com.example.bmicalculator.kotlinclasses;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bmicalculator.R
import kotlin.math.roundToInt
import kotlinx.android.synthetic.main.fragment_bmi.*

class BmiFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_bmi, container, false)
        val oblicz = view.findViewById<Button>(R.id.oblicz)
        oblicz.setOnClickListener { obliczBMI() }

        return view
    }

    private fun obliczBMI() {

        if(waga.text.isNullOrEmpty() || wzrost.text.isNullOrEmpty()) {
            wynik!!.text = getString(R.string.podaj_waga_wzrost)
        } else {
            val S1 = waga!!.text.toString()
            val S2 = wzrost!!.text.toString()
            val wagaValue = S1.toFloat()
            val wzrostValue = S2.toFloat() / 100
            var bmi = wagaValue / (wzrostValue * wzrostValue)
            bmi = bmi.roundToInt().toFloat()
            printBMI(bmi)
        }
    }

    private fun printBMI(bmi: Float) {

        val wynikBMI: String

        wynikBMI = if (bmi < 16) {
            "Wygłodzenie"
        } else if (bmi >= 16 && bmi < 17) {
            "Wychudzenie"
        } else if (bmi >= 17 && bmi < 18.5) {
            "Niedowaga"
        } else if (bmi >= 18.5 && bmi < 25) {
            "Waga prawidłowa"
        } else if (bmi >= 25 && bmi < 30) {
            "Nadwaga"
        } else if (bmi >= 30 && bmi < 35) {
            "Otyłość I stopnia"
        } else if (bmi >= 35 && bmi < 40) {
            "Otyłość II stopnia"
        } else {
            "Otyłość III stopnia"
        }

        val obliczenia = bmi.toString() + "\n" + wynikBMI
        wynik!!.text = obliczenia
    }
}
