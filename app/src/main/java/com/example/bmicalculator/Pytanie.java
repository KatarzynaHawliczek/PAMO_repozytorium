package com.example.bmicalculator;

public class Pytanie {

    String pytanie;
    String[] odpowiedzi = new String[4];
    String dobraOdp;

    Pytanie(String pytanie, String[] odpowiedzi, String dobraOdp) {

        this.pytanie = pytanie;
        this.odpowiedzi = odpowiedzi;
        this.dobraOdp = dobraOdp;

    }
}
