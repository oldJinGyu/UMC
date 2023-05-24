package com.example.mission8

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}