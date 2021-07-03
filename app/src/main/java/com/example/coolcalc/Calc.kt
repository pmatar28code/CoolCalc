package com.example.coolcalc

import android.widget.TextView
import com.example.coolcalc.databinding.ActivityMainBinding

class Calc {
    var listObjDoubleCalc = mutableListOf<Double>()
    var alreadyAresult = false
    var result = 0.0
    var stringOfNumbersForList =""
}

fun multiplicationBeforeResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iMinus = i - 1
    val iPlus = i + 1
    val a = listOfAll[iMinus].toDouble()
    val b = listOfAll[iPlus].toDouble()
    val multi = a * b;listOfObjCalc.result= multi
    listOfAll[i]="D"
    listOfObjCalc.alreadyAresult = true
}

fun sumBeforeResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iMinus = i - 1
    val iPlus = i + 1
    val a = listOfAll[iMinus].toDouble()
    val b = listOfAll[iPlus].toDouble()
    val plus = a + b
    listOfObjCalc.result= plus
    listOfAll[i]="D"
    listOfObjCalc.alreadyAresult = true
}

fun minusBeforeResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iMinus = i - 1
    val iPlus = i + 1
    val a = listOfAll[iMinus].toDouble()
    val b = listOfAll[iPlus].toDouble()
    val minus = a - b
    listOfObjCalc.result= minus
    listOfAll[i]="D"
    listOfObjCalc.alreadyAresult = true
}

fun divisionBeforeResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iMinus = i - 1
    val iPlus = i + 1
    val a = listOfAll[iMinus].toDouble()
    val b = listOfAll[iPlus].toDouble()
    val division = a / b
    listOfObjCalc.result= division
    listOfAll[i]="D"
    listOfObjCalc.alreadyAresult = true
}

fun multiplicationAfterResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iPlus=i+1
    val c = listOfAll[iPlus].toDouble()
    val result = listOfObjCalc.result
    val multi = result * c
    listOfObjCalc.result=multi
    listOfObjCalc.alreadyAresult=true
    listOfAll[i]="D"
}

fun sumAfterResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iPlus=i+1
    val c = listOfAll[iPlus].toDouble()
    val result = listOfObjCalc.result
    val plus = result + c
    listOfObjCalc.result=plus
    listOfObjCalc.alreadyAresult=true
    listOfAll[i]="D"
}

fun minusAfterResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iPlus=i+1
    val c = listOfAll[iPlus].toDouble()
    val result = listOfObjCalc.result
    val minus = result - c
    listOfObjCalc.result=minus
    listOfObjCalc.alreadyAresult=true
    listOfAll[i]="D"
}

fun divisionAfterResult(listOfObjCalc: Calc, listOfAll: MutableList<String>, number:String){
    val i = listOfAll.indexOf(number)
    val iPlus=i+1
    val c = listOfAll[iPlus].toDouble()
    val result = listOfObjCalc.result
    val division = result / c
    listOfObjCalc.result=division
    listOfObjCalc.alreadyAresult=true
    listOfAll[i]="D"
}

fun searchForOperations(listOfObjCalc: Calc,listOfAll: MutableList<String>):Calc {
    for (number in listOfAll) {
        if (!listOfObjCalc.alreadyAresult) {
            when (number) {
                "x" -> {
                    multiplicationBeforeResult(listOfObjCalc,listOfAll,number)
                }
                "+" -> {
                    sumBeforeResult(listOfObjCalc,listOfAll,number)
                }
                "-" -> {
                    minusBeforeResult(listOfObjCalc,listOfAll,number)
                }
                "/" -> {
                    divisionBeforeResult(listOfObjCalc,listOfAll,number)
                }
            }
        } else{ when(number){
            "x"->{
                multiplicationAfterResult(listOfObjCalc,listOfAll,number)
            }
            "/"-> {
               divisionAfterResult(listOfObjCalc,listOfAll,number)
            }
            "+"->{
               sumAfterResult(listOfObjCalc,listOfAll,number)
            }
            "-"->   {
               minusAfterResult(listOfObjCalc,listOfAll,number)
            }
        }
        }
    }
    return listOfObjCalc
}

fun showResult( objectCalc: Calc,textView: TextView): TextView {
    val a = objectCalc.result
    val result = a.toString()
    textView.text = result
    return textView
}

fun createListFromString(obj:Calc):MutableList<String> {
    var number = ""
    val tempList = mutableListOf<String>()
    var modString=obj.stringOfNumbersForList
    if(modString.last() != 'r'){
        modString+="r"
    }
    if(modString[0] =='r'){
        modString= modString.removeRange(0,1)
    }
    for (n in modString) {
        if (n == 'x' || n == '/' || n == '+' || n == '-') {
            val x = n
            val p = x.toString()
            if(number != ""){
                tempList.add(number)
            }else{
                tempList.add(number)
            }
            tempList.add(p)
            number = ""
        } else {
            if (n == 'r') {
                tempList.add(number)
            } else {
                val x = n
                val p = x.toString()
                number += p
            }
        }
    }
    return tempList
}

//updates operation text
fun deleteOneOpText(textview:TextView):TextView{
    var new = textview.text.toString()
    new= new.dropLast(1)
    textview.text = new
    return textview
}

//adds everything i type to the list separately
var listOfNumbers = mutableListOf<String>()

//saves numbers that are before and after operator
var tempStringNumbers: String = ""