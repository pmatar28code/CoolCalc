package com.example.coolcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.example.coolcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //object for search for operations and beyond
    var objForAll = Calc()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var inflater = LayoutInflater.from(this)
        var binding = ActivityMainBinding.inflate(inflater)
        setContentView(binding.root)
        Calc().activityMainBinding = binding


        val operationsText = findViewById<TextView>(R.id.textMultiInput)
        val resultText = findViewById<TextView>(R.id.textResult)

        binding.apply {
            buttonDot.setOnClickListener {
                val dot = "."
                tempStringNumbers += "."
                followUpText(dot, operationsText)
            }
            buttonEquals.setOnClickListener {
                //var addBeforeResult = "r"
                tempStringNumbers += "r"
                objForAll.stringOfNumbersForList = tempStringNumbers
                listOfNumbers = createListFromString(objForAll)
                objForAll = searchForOperations(objForAll, listOfNumbers)
                tempStringNumbers = ""
                listOfNumbers.clear()
                showResult(objForAll, resultText)
            }
            buttonDivision.setOnClickListener {
                val division = "/"
                tempStringNumbers += "/"
                followUpText(division, operationsText)
            }
            buttonMinus.setOnClickListener {
                val minus = "-"
                tempStringNumbers += "-"
                followUpText(minus, operationsText)
            }
            buttonPlus.setOnClickListener {
                val plus = "+"
                tempStringNumbers += "+"
                followUpText(plus, operationsText)
            }
            buttonTimes.setOnClickListener {
                val times = "x"
                tempStringNumbers += "x"
                followUpText(times, operationsText)
            }
            buttonC.setOnClickListener {
                tempStringNumbers = ""
                objForAll.stringOfNumbersForList = ""
                objForAll.alreadyAresult = false
                objForAll.listObjDoubleCalc.clear()
                objForAll.result = 0.0
                listOfNumbers.clear()
                resultText.text = ""
                operationsText.text = ""
            }
            buttonBack.setOnClickListener {
                tempStringNumbers = tempStringNumbers.dropLast(1)
                deleteOneOpText(operationsText)
            }
            buttonCero.setOnClickListener {
                val zero = "0"
                tempStringNumbers += "0"
                followUpText(zero, operationsText)
            }
            button1.setOnClickListener {
                val one = "1"
                tempStringNumbers += "1"
                followUpText(one, operationsText)
            }
            button2.setOnClickListener {
                val two = "2"
                tempStringNumbers += "2"
                followUpText(two, operationsText)
            }
            button3.setOnClickListener {
                val three = "3"
                tempStringNumbers += "3"
                followUpText(three, operationsText)
            }
            button4.setOnClickListener {
                val four = "4"
                tempStringNumbers += "4"
                followUpText(four, operationsText)
            }
            button5.setOnClickListener {
                val five = "5"
                tempStringNumbers += "5"
                followUpText(five, operationsText)
            }
            button6.setOnClickListener {
                val six = "6"
                tempStringNumbers += "6"
                followUpText(six, operationsText)
            }
            button7.setOnClickListener {
                val seven = "7"
                tempStringNumbers += "7"
                followUpText(seven, operationsText)
            }
            button8.setOnClickListener {
                val eight = "8"
                tempStringNumbers += "8"
                followUpText(eight, operationsText)
            }
            button9.setOnClickListener {
                val nine = "9"
                tempStringNumbers += "9"
                followUpText(nine, operationsText)
            }
        }
    }
    //updates operation textview
    private   fun followUpText(number: String,textView: TextView):TextView{
        var continueText = textView.text.toString()
        textView.text = number
        continueText+=textView.text
        textView.text = continueText
        return  textView
    }
}
