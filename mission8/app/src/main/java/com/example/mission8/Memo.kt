package com.example.mission8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
class Memo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no : Int? = null
    @ColumnInfo
    var text: String = ""
    @ColumnInfo
    var checkheart: Boolean = false
    @ColumnInfo
    var checkstar: Boolean = false

    constructor(text : String){
        this.text = text
    }
}