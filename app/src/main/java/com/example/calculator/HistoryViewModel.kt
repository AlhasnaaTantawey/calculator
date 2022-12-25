package com.example.calculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HistoryViewModel(application: Application) :AndroidViewModel( application) {

 var list =MutableLiveData<List<LastExpression>>()



   var db =ResultRoomDatabase.getDatabase(getApplication<Application>().applicationContext)
   private   var repository = ResultRepositary(db.resultDao())

    init {
       //  val expressionRepository = ExpressionApp().expressionRepository
   //  list=expressionRepository.getAllExpression()

    viewModelScope.launch(Dispatchers.IO) {
       // list.value=repository.getAllExpression()
        list.postValue(repository.getAllExpression())
    }
    }
}