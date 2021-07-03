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

        val operationsText = binding.textMultiInput
        setOnclickListenersToButtons(binding,operationsText)
    }
    //updates operation textview
    private   fun followUpText(number: String,textView: TextView):TextView{
        var continueText = textView.text.toString()
        textView.text = number
        continueText+=textView.text
        textView.text = continueText
        return  textView
    }

    private fun setOnclickListenersToButtons(binding:ActivityMainBinding,operationsText:TextView){
        binding.apply {
            buttonDot.setOnClickListener {
                val dot = "."
                tempStringNumbers += "."
                followUpText(dot,textMultiInput)
            }
            buttonEquals.setOnClickListener {
                tempStringNumbers += "r"
                objForAll.stringOfNumbersForList = tempStringNumbers
                listOfNumbers = createListFromString(objForAll)
                objForAll = searchForOperations(objForAll, listOfNumbers)
                tempStringNumbers = ""
                listOfNumbers.clear()
                showResult(objForAll, textResult)
            }
            buttonDivision.setOnClickListener {
                val division = "/"
                tempStringNumbers += "/"
                followUpText(division, textMultiInput)
            }
            buttonMinus.setOnClickListener {
                val minus = "-"
                tempStringNumbers += "-"
                followUpText(minus, textMultiInput)
            }
            buttonPlus.setOnClickListener {
                val plus = "+"
                tempStringNumbers += "+"
                followUpText(plus, textMultiInput)
            }
            buttonTimes.setOnClickListener {
                val times = "x"
                tempStringNumbers += "x"
                followUpText(times, textMultiInput)
            }
            buttonC.setOnClickListener {
                tempStringNumbers = ""
                objForAll.stringOfNumbersForList = ""
                objForAll.alreadyAresult = false
                objForAll.listObjDoubleCalc.clear()
                objForAll.result = 0.0
                listOfNumbers.clear()
                textResult.text = ""
                operationsText.text = ""
            }
            buttonBack.setOnClickListener {
                tempStringNumbers = tempStringNumbers.dropLast(1)
                deleteOneOpText(textMultiInput)
            }
            buttonCero.setOnClickListener {
                val zero = "0"
                tempStringNumbers += "0"
                followUpText(zero, textMultiInput)
            }
            button1.setOnClickListener {
                val one = "1"
                tempStringNumbers += "1"
                followUpText(one, textMultiInput)
            }
            button2.setOnClickListener {
                val two = "2"
                tempStringNumbers += "2"
                followUpText(two, textMultiInput)
            }
            button3.setOnClickListener {
                val three = "3"
                tempStringNumbers += "3"
                followUpText(three, textMultiInput)
            }
            button4.setOnClickListener {
                val four = "4"
                tempStringNumbers += "4"
                followUpText(four, textMultiInput)
            }
            button5.setOnClickListener {
                val five = "5"
                tempStringNumbers += "5"
                followUpText(five, textMultiInput)
            }
            button6.setOnClickListener {
                val six = "6"
                tempStringNumbers += "6"
                followUpText(six, textMultiInput)
            }
            button7.setOnClickListener {
                val seven = "7"
                tempStringNumbers += "7"
                followUpText(seven, textMultiInput)
            }
            button8.setOnClickListener {
                val eight = "8"
                tempStringNumbers += "8"
                followUpText(eight, textMultiInput)
            }
            button9.setOnClickListener {
                val nine = "9"
                tempStringNumbers += "9"
                followUpText(nine, textMultiInput)
            }
        }
    }
}
