package com.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var op:String=""
    private var oldNumber:String=""
    private var isNewOp:Boolean=true

    fun buNumEvent(view: View){
        if (isNewOp){
            editShow.setText("")
            isNewOp=false
        }

        val buSelect=view as Button
        var buClickValue=editShow.text.toString()

        when(buSelect.id)
        {
            bu0.id -> {
                buClickValue+="0"
            }
            bu1.id -> {
                buClickValue+="1"
            }
            bu2.id -> {
                buClickValue+="2"
            }
            bu3.id -> {
                buClickValue+="3"
            }
            bu4.id -> {
                buClickValue+="4"
            }
            bu5.id -> {
                buClickValue+="5"
            }
            bu6.id -> {
                buClickValue+="6"
            }
            bu7.id -> {
                buClickValue+="7"
            }
            bu8.id -> {
                buClickValue+="8"
            }
            bu9.id -> {
                buClickValue+="9"
            }
            buDot.id -> {
                if (!buClickValue.contains(".")){
                    buClickValue+="."
                }
            }
            buPlusMinus.id -> {
                buClickValue = if (buClickValue[0]!='-'){
                    "-$buClickValue"
                } else{
                    buClickValue.replace("-","")
                }
            }
        }
        editShow.setText(buClickValue)
    }

    fun buOpEvent(view: View){
        val buSelect=view as Button

        when(buSelect.id)
        {
            buMul.id -> {
                op="*"
            }
            buDiv.id -> {
                op="÷"
            }
            buSub.id -> {
                op="-"
            }
            buSum.id -> {
                op="+"
            }

        }
        oldNumber=editShow.text.toString()
        isNewOp=true
    }

    fun buEqualEvent (view:View){
        val newNumber=editShow.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber=oldNumber.toDouble()*newNumber.toDouble()
            }
            "÷"->{
                finalNumber=oldNumber.toDouble()/newNumber.toDouble()
            }
            "+"->{
                finalNumber=oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber=oldNumber.toDouble()-newNumber.toDouble()
            }
        }
        editShow.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View){
        val number = editShow.text.toString().toDouble() / 100

        editShow.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View){
        editShow.setText("0")
        isNewOp=true
    }

}
