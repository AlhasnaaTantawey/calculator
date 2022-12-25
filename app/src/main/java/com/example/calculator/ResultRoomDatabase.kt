package com.example.calculator

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =arrayOf(LastExpression::class), version = 1, exportSchema = false)
abstract class ResultRoomDatabase : RoomDatabase() {
    abstract  fun resultDao() : LastExpressionDao

    companion object{

        private var INSTANCE :ResultRoomDatabase?=null
        fun getDatabase(context: Context) :ResultRoomDatabase {
            if(INSTANCE ==null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    ResultRoomDatabase::class.java,
                    "myDatabase"
                ).build()
            }
            return INSTANCE as ResultRoomDatabase

        }

    }

}