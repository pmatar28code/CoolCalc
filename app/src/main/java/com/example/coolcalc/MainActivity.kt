package com.example.coolcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //object for search for operations and beyond
    var objForAll = Calc()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val operationsText = findViewById<TextView>(R.id.textMultiInput)
        val resultText = findViewById<TextView>(R.id.textResult)
        val backButton = findViewById<Button>(R.id.buttonBack)
        val clearButton = findViewById<Button>(R.id.buttonC)
        val oneButton = findViewById<Button>(R.id.button1)
        val twoButton = findViewById<Button>(R.id.button2)
        val threeButton = findViewById<Button>(R.id.button3)
        val fourButton = findViewById<Button>(R.id.button4)
        val fiveButton = findViewById<Button>(R.id.button5)
        val sixButton = findViewById<Button>(R.id.button6)
        val sevenButton = findViewById<Button>(R.id.button7)
        val eightButton = findViewById<Button>(R.id.button8)
        val nineButton = findViewById<Button>(R.id.button9)
        val ceroButton = findViewById<Button>(R.id.buttonCero)
        val plusButton = findViewById<Button>(R.id.buttonPlus)
        val minusButton = findViewById<Button>(R.id.buttonMinus)
        val timesButton = findViewById<Button>(R.id.buttonTimes)
        val divisionButton = findViewById<Button>(R.id.buttonDivision)
        val equalsButton = findViewById<Button>(R.id.buttonEquals)
        val dotButton = findViewById<Button>(R.id.buttonDot)



        dotButton.setOnClickListener {
            val dot ="."
            tempStringNumbers+="."
            followUpText(dot,operationsText)
        }



        equalsButton.setOnClickListener {
            var addBeforeResult ="r"
            tempStringNumbers+="r"
            objForAll.stringOfNumbersForList=tempStringNumbers
            listOfNumbers = createListFromString(objForAll)
            objForAll = searchForOperations(objForAll,listOfNumbers)
            tempStringNumbers=""
            listOfNumbers.clear()
            showResult(objForAll,resultText)
        }

        divisionButton.setOnClickListener {
            val division = "/"
            tempStringNumbers+="/"
            followUpText(division,operationsText)
        }
        minusButton.setOnClickListener {
            val minus = "-"
            tempStringNumbers+="-"
            followUpText(minus,operationsText)
        }
        plusButton.setOnClickListener  {
            val plus = "+"
            tempStringNumbers+="+"
            followUpText(plus,operationsText)
        }
        timesButton.setOnClickListener {
            val times = "x"
            tempStringNumbers+="x"
            followUpText(times,operationsText)
        }

        clearButton.setOnClickListener{
            tempStringNumbers =""
            objForAll.stringOfNumbersForList=""
            objForAll.alreadyAresult=false
            objForAll.listObjDoubleCalc.clear()
            objForAll.result=0.0
            listOfNumbers.clear()
            resultText.text=""
            operationsText.text = ""
        }
        backButton.setOnClickListener {
            tempStringNumbers = tempStringNumbers.dropLast(1)
            deleteOneOpText(operationsText)
        }
        ceroButton.setOnClickListener {
            val zero = "0"
            tempStringNumbers+="0"
            followUpText(zero,operationsText)
        }
        oneButton.setOnClickListener {
            val one = "1"
            tempStringNumbers+="1"
            followUpText(one,operationsText)
        }

        twoButton.setOnClickListener {
            val two = "2"
            tempStringNumbers+="2"
            followUpText(two,operationsText)
        }

        threeButton.setOnClickListener {
            val three = "3"
            tempStringNumbers+="3"
            followUpText(three,operationsText)
        }


        fourButton.setOnClickListener {
            val four = "4"
            tempStringNumbers+="4"
            followUpText(four,operationsText)
        }

        fiveButton.setOnClickListener {
            val five = "5"
            tempStringNumbers+="5"
            followUpText(five,operationsText)
        }

        sixButton.setOnClickListener {
            val six = "6"
            tempStringNumbers+="6"
            followUpText(six,operationsText)
        }


        sevenButton.setOnClickListener {
            val seven = "7"
            tempStringNumbers+="7"
            followUpText(seven,operationsText)
        }


        eightButton.setOnClickListener {
            val eight = "8"
            tempStringNumbers+="8"
            followUpText(eight,operationsText)
        }


        nineButton.setOnClickListener {
            val nine = "9"
            tempStringNumbers+="9"
            followUpText(nine,operationsText)
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
