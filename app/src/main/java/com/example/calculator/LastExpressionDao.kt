package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface LastExpressionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun  insert(expreation :LastExpression)

    @Query("select * from expreation_table order by id desc limit 1")
    fun getLastExpression() : LiveData<LastExpression>

    @Query("select * from expreation_table")
  suspend  fun getAllExpression() :List<LastExpression>
}