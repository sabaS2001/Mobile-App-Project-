package com.example.project2

import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ComponentActivity


@SuppressLint("RestrictedApi")
class OrderPart : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_part)

        var rs: Cursor? = contentResolver.query(
            CustomerProvider.CONTENT_URI,
            arrayOf(
                CustomerProvider.cid,
                CustomerProvider.name,
                CustomerProvider.price,
                CustomerProvider.quantity
            ),
            null, null, null
        )
        val updateB: Button = findViewById(R.id.updateButton)
        val confirmB: Button = findViewById(R.id.confirmButton)
        val deleteB: Button = findViewById(R.id.deleteButton)

        val names : EditText = findViewById(R.id.name)
        val prices : EditText = findViewById(R.id.price)
        val quant : EditText = findViewById(R.id.quantity)

        updateB.setOnClickListener(){

        }
        confirmB.setOnClickListener{
                if (rs?.moveToNext()!!)
                    names.setText(rs.getString(1))
                    prices.setText(rs.getString(2))
                    quant.setText(rs.getString(3))
        }
        deleteB.setOnClickListener(){

        }
    }

}