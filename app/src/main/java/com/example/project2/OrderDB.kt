package com.example.project2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OrderDB (context : Context?) : SQLiteOpenHelper(context, "CAFE", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE customer( customer_id INTEGER PRIMARY KEY AUTOINCREMENT, order_name TEXT, order_price DOUBLE, quantity INTEGER )")
        db?.execSQL("INSERT into customer(order_name, order_price, quantity) VALUES('Vanilla Latte', 2.50, 1)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}