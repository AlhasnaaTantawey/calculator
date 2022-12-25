package com.example.calculator

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyViewModel(application: Application) :AndroidViewModel(application) {

    private var currentNumber = MutableLiveData("")
    private var resultNumber = MutableLiveData("")
    var lastResult :LiveData<LastExpression>
    var outputLiveData = MediatorLiveData<String>()
    private var firstNumber = 0
    private var secondNumber =0
    private var operation = ""

  var db =ResultRoomDatabase.getDatabase(getApplication<Application>().applicationContext)

    init {

        outputLiveData.addSource(currentNumber) {
            outputLiveData.value = it
        }
        outputLiveData.addSource(resultNumber) {
            outputLiveData.value = it
        }
      lastResult = db.resultDao().getLastExpression()
    }

    fun equalOnclick() {
        this.secondNumber = currentNumber.value?.toInt() ?: 0
        currentNumber.value = ""
        when (operation) {

            "+" -> {
                resultNumber.value = (firstNumber + secondNumber).toString()
            }
            "/" -> {
                resultNumber.value = (firstNumber / secondNumber).toString()
            }
            "-" -> {
                resultNumber.value = (firstNumber - secondNumber).toString()
            }
            "*" -> {
                resultNumber.value = (firstNumber * secondNumber).toString()
            }
        }
        var res = "$firstNumber$operation$secondNumber=${resultNumber.value}"
 viewModelScope.launch(Dispatchers.IO){
     db.resultDao().insert(LastExpression(result = res))
 }


    }

    fun valueMethod() {
        //let used with null safty
        currentNumber.value?.let {
         firstNumber= it.toInt()
        }
        // firstNumber = currentNumber.value?.toInt() ?: -1
        currentNumber.value = ""
    }

    fun plusOnClick() {
        valueMethod()
        operation = "+"
    }

    fun subOnClick() {
        valueMethod()
        operation = "-"
    }

    fun divisionOnClick() {
        valueMethod()
        operation = "/"
    }

    fun multyOnClick() {
        valueMethod()
        operation = "*"
    }


    fun number0OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}0"
        //firstNumber.value=firstNumber.value+0
    }

    fun number1OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}1"

    }

    fun number2OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}2"

    }

    fun number3OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}3"

    }

    fun number4OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}4"

    }

    fun number5OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}5"

    }

    fun number6OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}6"
    }

    fun number7OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}7"

    }

    fun number8OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}8"

    }

    fun number9OnClick() {
        this.currentNumber.value = "${this.currentNumber.value}9"

    }

    fun numberDotOnClick() {
        this.currentNumber.value = "${this.currentNumber.value}."
    }

    fun clearOnClick() {
        currentNumber.value = ""
    }

    fun plusMinusOnClick() {
        this.currentNumber.value = "${this.currentNumber.value}-"
    }

}