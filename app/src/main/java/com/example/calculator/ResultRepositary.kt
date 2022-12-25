package com.example.calculator

import androidx.lifecycle.LiveData

class ResultRepositary (private  val resultDao :LastExpressionDao){
   suspend fun insert(expression:LastExpression) {
        resultDao.insert(expression)
    }

    fun getLastExpression(): LiveData<LastExpression> {
        return resultDao.getLastExpression()
    }

     suspend fun getAllExpression() :List<LastExpression>{
        return  resultDao.getAllExpression()
    }
}