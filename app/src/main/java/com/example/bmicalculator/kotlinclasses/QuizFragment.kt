package com.example.bmicalculator.kotlinclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bmicalculator.R

class QuizFragment : Fragment() {

    private var licznik: TextView? = null
    private var punkty: TextView? = null
    private var licznikTxt: TextView? = null
    private var punktyTxt: TextView? = null
    private var tresc: TextView? = null
    private var pytania = arrayOfNulls<Pytanie>(9)
    private var odpA: Button? = null
    private var odpB: Button? = null
    private var odpC: Button? = null
    private var odpD: Button? = null
    private var numerPytania = 0
    private var wynik = 0
    private var poprawnaOdp = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        odpA = view.findViewById(R.id.odpA)
        odpA?.run { setOnClickListener(buttonListener) }
        odpB = view.findViewById(R.id.odpB)
        odpB?.run { setOnClickListener(buttonListener) }
        odpC = view.findViewById(R.id.odpC)
        odpC?.run { setOnClickListener(buttonListener) }
        odpD = view.findViewById(R.id.odpD)
        odpD?.run { setOnClickListener(buttonListener) }
        tresc = view.findViewById(R.id.tresc)
        punkty = view.findViewById(R.id.punkty)
        licznik = view.findViewById(R.id.licznik)
        punktyTxt = view.findViewById(R.id.punktyTxt)
        licznikTxt = view.findViewById(R.id.licznikTxt)

        wczytajQuiz()
        wczytajPytanie()
    }

    private fun wczytajQuiz() {

        pytania = arrayOf(
                Pytanie(
                        resources.getString(R.string.pyt1),
                        arrayOf(
                                resources.getString(R.string.odp1A),
                                resources.getString(R.string.odp1B),
                                resources.getString(R.string.odp1C),
                                resources.getString(R.string.odp1D)),
                        resources.getString(R.string.odp1C)),
                Pytanie(
                        resources.getString(R.string.pyt2),
                        arrayOf(
                                resources.getString(R.string.odp2A),
                                resources.getString(R.string.odp2B),
                                resources.getString(R.string.odp2C),
                                resources.getString(R.string.odp2D)),
                        resources.getString(R.string.odp2D)),
                Pytanie(
                        resources.getString(R.string.pyt3),
                        arrayOf(
                                resources.getString(R.string.odp3A),
                                resources.getString(R.string.odp3B),
                                resources.getString(R.string.odp3C),
                                resources.getString(R.string.odp3D)),
                        resources.getString(R.string.odp3A)),
                Pytanie(
                        resources.getString(R.string.pyt4),
                        arrayOf(
                                resources.getString(R.string.odp4A),
                                resources.getString(R.string.odp4B),
                                resources.getString(R.string.odp4C),
                                resources.getString(R.string.odp4D)),
                        resources.getString(R.string.odp4C)),
                Pytanie(
                        resources.getString(R.string.pyt5),
                        arrayOf(
                                resources.getString(R.string.odp5A),
                                resources.getString(R.string.odp5B),
                                resources.getString(R.string.odp5C),
                                resources.getString(R.string.odp5D)),
                        resources.getString(R.string.odp5B)),
                Pytanie(
                        resources.getString(R.string.pyt6),
                        arrayOf(
                                resources.getString(R.string.odp6A),
                                resources.getString(R.string.odp6B),
                                resources.getString(R.string.odp6C),
                                resources.getString(R.string.odp6D)),
                        resources.getString(R.string.odp6C)),
                Pytanie(
                        resources.getString(R.string.pyt7),
                        arrayOf(
                                resources.getString(R.string.odp7A),
                                resources.getString(R.string.odp7B),
                                resources.getString(R.string.odp7C),
                                resources.getString(R.string.odp7D)),
                        resources.getString(R.string.odp7A)),
                Pytanie(
                        resources.getString(R.string.pyt8),
                        arrayOf(
                                resources.getString(R.string.odp8A),
                                resources.getString(R.string.odp8B),
                                resources.getString(R.string.odp8C),
                                resources.getString(R.string.odp8D)),
                        resources.getString(R.string.odp8B)),
                Pytanie(
                        resources.getString(R.string.pyt9),
                        arrayOf(
                                resources.getString(R.string.odp9A),
                                resources.getString(R.string.odp9B),
                                resources.getString(R.string.odp9C),
                                resources.getString(R.string.odp9D)),
                        resources.getString(R.string.odp9D))
        )
    }

    private val buttonListener = View.OnClickListener { view ->

        val button = view as Button
        val odpowiedz = button.text.toString()

        if (numerPytania <= 9) {

            if (odpowiedz == poprawnaOdp) {
                wynik += 1
                punkty!!.text = Integer.toString(wynik)
            }

            wczytajPytanie()
        } else {

            if (button.id == R.id.odpA) {

                wynik = 0
                numerPytania = 0
                odpB!!.visibility = View.VISIBLE
                odpC!!.visibility = View.VISIBLE
                odpD!!.visibility = View.VISIBLE
                licznikTxt!!.visibility = View.VISIBLE
                punktyTxt!!.visibility = View.VISIBLE
                licznik!!.visibility = View.VISIBLE
                punkty!!.visibility = View.VISIBLE
                wczytajPytanie()
            }
        }
    }

    private fun wczytajPytanie() {

        if (numerPytania < 9) {

            val wyswietlonePytanie = pytania[numerPytania]
            tresc!!.text = wyswietlonePytanie!!.pytanie
            odpA!!.text = wyswietlonePytanie.odpowiedzi[0]
            odpB!!.text = wyswietlonePytanie.odpowiedzi[1]
            odpC!!.text = wyswietlonePytanie.odpowiedzi[2]
            odpD!!.text = wyswietlonePytanie.odpowiedzi[3]
            poprawnaOdp = wyswietlonePytanie.dobraOdp
            numerPytania = numerPytania + 1
            licznik!!.text = Integer.toString(numerPytania) + " z 9"
        } else {

            numerPytania = 10
            tresc!!.text = "Twój wynik: " + Integer.toString(wynik)
            odpA!!.setText(R.string.koniec)
            odpB!!.visibility = View.INVISIBLE
            odpC!!.visibility = View.INVISIBLE
            odpD!!.visibility = View.INVISIBLE
            punkty!!.visibility = View.INVISIBLE
            punkty!!.setText(R.string.zero)
            punktyTxt!!.visibility = View.INVISIBLE
            licznik!!.visibility = View.INVISIBLE
            licznikTxt!!.visibility = View.INVISIBLE
        }
    }
}



