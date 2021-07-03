package com.example.coolcalc

import org.junit.Assert
import org.junit.Test

class CalculatorUnitTest {
    //I also performed Espresso test on Android Test
    fun testProcedure(operationString:String,expected:Double){
        var objectForOperations = Calc()
        val tempString = operationString
        objectForOperations.stringOfNumbersForList = tempString
        val listOfNumbers = createListFromString(objectForOperations)
        objectForOperations = searchForOperations(objectForOperations,listOfNumbers)
        Assert.assertEquals(expected,objectForOperations.result,expected)
    }
    @Test
    fun `check if sum operation is correct`(){
        testProcedure("2+4r",6.0)
    }
    @Test
    fun `check if minus operation is correct`(){
        testProcedure("100-80r",20.0)
    }
    @Test
    fun `check if multiplying operation is correct`(){
        testProcedure("200x44r",8800.0)
    }
    @Test
    fun `check if division operation is correct`(){
        testProcedure("784/32r",24.5)
    }
    @Test
    fun `check if combined operations is correct`(){
        testProcedure("28+12-19x82/8x3-8+2/4r",159.9375)
    }
    @Test
    fun `if nothing is entered and user press equals button`(){
        testProcedure("r",0.0)
    }
}