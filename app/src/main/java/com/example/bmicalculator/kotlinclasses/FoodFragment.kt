package com.example.bmicalculator.kotlinclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.bmicalculator.R


class FoodFragment : Fragment() {

    private var bmi: EditText? = null
    private var produkty: ListView? = null
    private var potrawa: TextView? = null
    private var przepis: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_food, container, false)

        bmi = view.findViewById(R.id.bmi)
        val co_zjesc = view.findViewById<Button>(R.id.co_zjesc)
        potrawa = view.findViewById(R.id.potrawa)
        przepis = view.findViewById(R.id.przepis)
        produkty = view.findViewById(R.id.produkty)

        co_zjesc.setOnClickListener { pokazPrzepis() }

        return view
    }

    private fun pokazPrzepis() {

        val S1 = bmi!!.text.toString()
        var bmiValue = 0f

        if (!S1.isEmpty()) {

            bmiValue = S1.toFloat()
        } else {

            potrawa!!.setText(R.string.uwaga)
            przepis!!.text = ""
            val produktyLista = arrayOf("")
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, produktyLista)
            produkty!!.adapter = adapter
        }

        if (bmiValue > 0 && bmiValue < 18.5) {

            potrawa!!.setText(R.string.potrawa1)
            przepis!!.setText(R.string.przepis1)
            val produktyLista = resources.getStringArray(R.array.produktyList1)
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, produktyLista)
            produkty!!.adapter = adapter
        } else if (bmiValue >= 18.5 && bmiValue <= 25) {

            potrawa!!.setText(R.string.potrawa2)
            przepis!!.setText(R.string.przepis2)
            val produktyLista = resources.getStringArray(R.array.produktyList2)
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, produktyLista)
            produkty!!.adapter = adapter
        } else if (bmiValue > 25) {

            potrawa!!.setText(R.string.potrawa3)
            przepis!!.setText(R.string.przepis3)
            val produktyLista = resources.getStringArray(R.array.produktyList3)
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, produktyLista)
            produkty!!.adapter = adapter
        }
    }
}
