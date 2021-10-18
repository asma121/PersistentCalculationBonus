package com.example.persistentcalculationbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var button: Button
    lateinit var textView: TextView
    var num1:Double=0.0
    var num2:Float=0f
    var result:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        button=findViewById(R.id.button)
        textView=findViewById(R.id.textView)


        button.setOnClickListener {
             num1=et1.text.toString().toDouble()
             num2=et2.text.toString().toFloat()
            result=num1*num2
            textView.text=result.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("num1", num1)
        outState.putFloat("num2", num2)
        outState.putDouble("result", result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        num1= savedInstanceState.getDouble("num1", 0.0)
        num2= savedInstanceState.getFloat("num2", 0f)
        result= savedInstanceState.getDouble("result", 0.0)
        textView.text="$result"
    }

}