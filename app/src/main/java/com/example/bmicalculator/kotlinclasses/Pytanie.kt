package com.example.bmicalculator.kotlinclasses

class Pytanie internal constructor(var pytanie: String, odpowiedzi: Array<String?>, dobraOdp: String) {

    var odpowiedzi = arrayOfNulls<String>(4)
    var dobraOdp: String

    init {

        this.odpowiedzi = odpowiedzi
        this.dobraOdp = dobraOdp
    }
}
