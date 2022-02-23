package com.example.proyectocalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null
    private var firstnum = ""
    private var operation = "+"

    private var reset = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numInsert(view: View) {
        if(reset)
            textView?.text = ""
        reset= false
        textView = findViewById<TextView>(R.id.textView)

        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btndot = findViewById<Button>(R.id.btn_dot)

        var click:String = textView?.text.toString()
        val select:Button = view as Button
        when(select.id){
            btn0.id -> click += "0"
            btn1.id -> click += "1"
            btn2.id -> click += "2"
            btn3.id -> click += "3"
            btn4.id -> click += "4"
            btn5.id -> click += "5"
            btn6.id -> click += "6"
            btn7.id -> click += "7"
            btn8.id -> click += "8"
            btn9.id -> click += "9"
            btndot.id -> click += "."
        }
        textView?.text = click
    }

    fun Operation(view: View) {
        reset= true
        textView = findViewById<TextView>(R.id.textView)
        val btnminus = findViewById<Button>(R.id.btn_minus)
        val btnplus = findViewById<Button>(R.id.btn_plus)
        val btnmulti = findViewById<Button>(R.id.btn_multi)
        val btndiv = findViewById<Button>(R.id.btn_div)

        firstnum = textView?.text.toString()
        val select:Button =view as Button
        when(select.id){
            btnminus.id -> operation = "-"
            btnplus.id -> operation = "+"
            btndiv.id -> operation = "/"
            btnmulti.id -> operation = "*"
        }

    }

    fun EQUAL(view: View) {
        textView = findViewById<TextView>(R.id.textView)
        val secondnum:String = textView?.text.toString()
        var final = 0.0
        when(operation){
            "+" -> final= firstnum.toDouble() + secondnum.toDouble()
            "-" -> final= firstnum.toDouble() - secondnum.toDouble()
            "/" -> final= firstnum.toDouble() / secondnum.toDouble()
            "*" -> final= firstnum.toDouble() * secondnum.toDouble()
        }
        textView?.text = final.toString()
    }

    fun CLEAR(view: View) {
        textView = findViewById<TextView>(R.id.textView)
        textView?.text= ""
        reset =true
    }
}