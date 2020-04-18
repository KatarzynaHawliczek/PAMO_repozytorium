//package com.example.bmicalculator.javaclasses;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//public class JQuizFragment extends Fragment {
//
//    private TextView licznik, punkty, licznikTxt, punktyTxt, tresc;
//    private JPytanie[] pytania = new JPytanie[9];
//    private Button odpA, odpB, odpC, odpD;
//    private int numerPytania = 0;
//    private int wynik = 0;
//    private String poprawnaOdp = "";
//
//    public JQuizFragment() {
//
//    }
//
//    public static JQuizFragment newInstance(String arg1, String arg2) {
//
//        JQuizFragment quizFragment = new JQuizFragment();
//        Bundle args = new Bundle();
//        quizFragment.setArguments(args);
//        return quizFragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        return inflater.inflate(R.layout.fragment_quiz, container, false);
//    }
//
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//
//        odpA = view.findViewById(R.id.odpA);
//        odpA.setOnClickListener(buttonListener);
//        odpB = view.findViewById(R.id.odpB);
//        odpB.setOnClickListener(buttonListener);
//        odpC = view.findViewById(R.id.odpC);
//        odpC.setOnClickListener(buttonListener);
//        odpD = view.findViewById(R.id.odpD);
//        odpD.setOnClickListener(buttonListener);
//        tresc = view.findViewById(R.id.tresc);
//        punkty = view.findViewById(R.id.punkty);
//        licznik = view.findViewById(R.id.licznik);
//        punktyTxt = view.findViewById(R.id.punktyTxt);
//        licznikTxt = view.findViewById(R.id.licznikTxt);
//
//        wczytajQuiz();
//        wczytajPytanie();
//    }
//
//    private void wczytajQuiz() {
//
//        pytania = new JPytanie[]{
//                new JPytanie(
//                        getResources().getString(R.string.pyt1),
//                        new String[]{
//                                getResources().getString(R.string.odp1A),
//                                getResources().getString(R.string.odp1B),
//                                getResources().getString(R.string.odp1C),
//                                getResources().getString(R.string.odp1D)
//                        },
//                        getResources().getString(R.string.odp1C)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt2),
//                        new String[]{
//                                getResources().getString(R.string.odp2A),
//                                getResources().getString(R.string.odp2B),
//                                getResources().getString(R.string.odp2C),
//                                getResources().getString(R.string.odp2D)
//                        },
//                        getResources().getString(R.string.odp2D)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt3),
//                        new String[]{
//                                getResources().getString(R.string.odp3A),
//                                getResources().getString(R.string.odp3B),
//                                getResources().getString(R.string.odp3C),
//                                getResources().getString(R.string.odp3D)
//                        },
//                        getResources().getString(R.string.odp3A)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt4),
//                        new String[]{
//                                getResources().getString(R.string.odp4A),
//                                getResources().getString(R.string.odp4B),
//                                getResources().getString(R.string.odp4C),
//                                getResources().getString(R.string.odp4D)
//                        },
//                        getResources().getString(R.string.odp4C)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt5),
//                        new String[]{
//                                getResources().getString(R.string.odp5A),
//                                getResources().getString(R.string.odp5B),
//                                getResources().getString(R.string.odp5C),
//                                getResources().getString(R.string.odp5D)
//                        },
//                        getResources().getString(R.string.odp5B)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt6),
//                        new String[]{
//                                getResources().getString(R.string.odp6A),
//                                getResources().getString(R.string.odp6B),
//                                getResources().getString(R.string.odp6C),
//                                getResources().getString(R.string.odp6D)
//                        },
//                        getResources().getString(R.string.odp6C)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt7),
//                        new String[]{
//                                getResources().getString(R.string.odp7A),
//                                getResources().getString(R.string.odp7B),
//                                getResources().getString(R.string.odp7C),
//                                getResources().getString(R.string.odp7D)
//                        },
//                        getResources().getString(R.string.odp7A)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt8),
//                        new String[]{
//                                getResources().getString(R.string.odp8A),
//                                getResources().getString(R.string.odp8B),
//                                getResources().getString(R.string.odp8C),
//                                getResources().getString(R.string.odp8D)
//                        },
//                        getResources().getString(R.string.odp8B)),
//
//                new JPytanie(
//                        getResources().getString(R.string.pyt9),
//                        new String[]{
//                                getResources().getString(R.string.odp9A),
//                                getResources().getString(R.string.odp9B),
//                                getResources().getString(R.string.odp9C),
//                                getResources().getString(R.string.odp9D)
//                        },
//                        getResources().getString(R.string.odp9D))
//        };
//    }
//
//    private View.OnClickListener buttonListener = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View view) {
//
//            Button button = ((Button)view);
//            String odpowiedz = button.getText().toString();
//
//            if(numerPytania <= 9) {
//                if(odpowiedz.equals(poprawnaOdp)) {
//                    wynik += 1;
//                    punkty.setText(Integer.toString(wynik));
//                }
//                wczytajPytanie();
//            } else {
//                if(button.getId() == R.id.odpA) {
//                    wynik = 0;
//                    numerPytania = 0;
//                    odpB.setVisibility(View.VISIBLE);
//                    odpC.setVisibility(View.VISIBLE);
//                    odpD.setVisibility(View.VISIBLE);
//                    licznikTxt.setVisibility(View.VISIBLE);
//                    punktyTxt.setVisibility(View.VISIBLE);
//                    licznik.setVisibility(View.VISIBLE);
//                    punkty.setVisibility(View.VISIBLE);
//                    wczytajPytanie();
//                }
//            }
//        }
//    };
//
//    private void wczytajPytanie() {
//
//        if(numerPytania < 9) {
//            JPytanie wyswietlonePytanie = pytania[numerPytania];
//            tresc.setText(wyswietlonePytanie.pytanie);
//            odpA.setText(wyswietlonePytanie.odpowiedzi[0]);
//            odpB.setText(wyswietlonePytanie.odpowiedzi[1]);
//            odpC.setText(wyswietlonePytanie.odpowiedzi[2]);
//            odpD.setText(wyswietlonePytanie.odpowiedzi[3]);
//            poprawnaOdp = wyswietlonePytanie.dobraOdp;
//            numerPytania = numerPytania + 1;
//            licznik.setText(Integer.toString(numerPytania) + " z 9");
//        } else {
//            numerPytania = 10;
//            tresc.setText("Twój wynik: " + Integer.toString(wynik));
//            odpA.setText(R.string.koniec);
//            odpB.setVisibility(View.INVISIBLE);
//            odpC.setVisibility(View.INVISIBLE);
//            odpD.setVisibility(View.INVISIBLE);
//            punkty.setVisibility(View.INVISIBLE);
//            punkty.setText(R.string.zero);
//            punktyTxt.setVisibility(View.INVISIBLE);
//            licznik.setVisibility(View.INVISIBLE);
//            licznikTxt.setVisibility(View.INVISIBLE);
//        }
//    }
//}



