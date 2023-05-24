package com.example.mission8

import androidx.room.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo")
    fun getAll(): List<Memo>

    @Insert
    fun insert(user: Memo)

    @Delete
    fun delete(user: Memo)

    @Update
    fun update(memo: Memo)

    @Query("SELECT * FROM memo WHERE checkstar = 1")
    fun getStarMemo(): List<Memo>
}