package com.example.project2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentActivity
import com.example.project2.R.layout

class Options : FragmentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_options)
        val cButton: Button = findViewById(R.id.coffeebutton)
        val bButton: Button = findViewById(R.id.bagelbutton)
        val caButton: Button = findViewById(R.id.cakeButton)
        val locButton: ImageButton = findViewById(R.id.locationimageButton)
        val orderButton : Button = findViewById(R.id.OrderButton)

        cButton.setOnClickListener{
            var dialogV = Coffee()
            dialogV.showNow(supportFragmentManager, "Coffee")
        }
        caButton.setOnClickListener{
            var dialogC = Cake()
            dialogC.showNow(supportFragmentManager, "Cake")
        }
        bButton.setOnClickListener{
            var dialogB = Bagels()
            dialogB.showNow(supportFragmentManager, "Bagels")
        }
        orderButton.setOnClickListener(){
            val intent1 = Intent(this, OrderPart:: class.java)
            startActivity(intent1)
        }
        locButton.setOnClickListener{
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=Espresso+Lab+St.+Regi,+Amman,+Jordan"
            ).let { location ->
                Intent(Intent.ACTION_VIEW, location)
            }
            startActivity(mapIntent);
        }


    }
}