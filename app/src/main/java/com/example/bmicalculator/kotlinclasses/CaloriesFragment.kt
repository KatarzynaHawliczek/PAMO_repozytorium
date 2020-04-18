package com.example.bmicalculator.kotlinclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.bmicalculator.R

class CaloriesFragment : Fragment(), OnItemSelectedListener {

    private var plecTxt: String? = null
    private var waga: EditText? = null
    private var wzrost: EditText? = null
    private var wiek: EditText? = null
    private var wynik: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_calories, container, false)

        waga = view.findViewById(R.id.waga)
        wzrost = view.findViewById(R.id.wzrost)
        wiek = view.findViewById(R.id.wiek)
        wynik = view.findViewById(R.id.wynik)
        val plec = view.findViewById<Spinner>(R.id.plec)

        val adapter: ArrayAdapter<CharSequence>
        adapter = ArrayAdapter.createFromResource(this.context!!, R.array.plecList, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        plec.adapter = adapter
        plec.onItemSelectedListener = this
        val oblicz = view.findViewById<Button>(R.id.oblicz)
        oblicz.setOnClickListener { obliczPPM() }

        return view
    }

    private fun obliczPPM() {

        val S1 = waga!!.text.toString()
        val S2 = wzrost!!.text.toString()
        val S3 = wiek!!.text.toString()

        val pl = getString(R.string.plecK)

        val wagaValue = S1.toDouble()
        val wzrostValue = S2.toDouble()
        val wiekValue = S3.toDouble()

        var ppm: Double

        ppm = if (plecTxt == pl) {
            655.1 + 9.567 * wagaValue + 1.85 * wzrostValue - 4.68 * wiekValue
        } else {
            66.47 + 13.7 * wagaValue + 5.0 * wzrostValue - 6.76 * wiekValue
        }

        ppm = Math.round(ppm).toDouble()
        val kalorie = "$ppm kcal"
        wynik!!.text = kalorie
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

        plecTxt = parent.getItemAtPosition(position).toString()
        Toast.makeText(parent.context, plecTxt, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}
