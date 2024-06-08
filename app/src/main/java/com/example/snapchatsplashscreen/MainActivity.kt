package com.example.snapchatsplashscreen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(300)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        //explicit intent
         val explicitButton = findViewById<Button>(R.id.expBtn)
        explicitButton.setOnClickListener {
            val explicitIntent = Intent(this, SpinnerActivity::class.java)
            startActivity(explicitIntent)

            //finish()       we can also use this ,then when back button is pressed it exits the app.
        }

        //Implicit Intent
        val url= "https://google.com"
        val implicitButton= findViewById<Button>(R.id.impBtn)
        implicitButton.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(implicitIntent)
        }

        //3rd button refering to the Second Activity page

        val secondActivityButton = findViewById<Button>(R.id.secondActivityBtn)
        secondActivityButton.setOnClickListener {
            val secondExplicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondExplicitIntent)

            //finish()       we can also use this ,then when back button is pressed it exits the app.
        }

        //4th button opeing the Alert Dialog Box

        val showalert : Button = findViewById(R.id.AlertBtn)

        showalert.setOnClickListener {
            showAlertDialog()
        }

        val fragmentButton =findViewById<Button>(R.id.FragmentBtn)
        fragmentButton.setOnClickListener {
            val fragmentButtonIntent= Intent(this, FragmentActivity::class.java)
            startActivity(fragmentButtonIntent)
        }

        val viewPagerbtn = findViewById<Button>(R.id.ViewPagerBtn)
        viewPagerbtn.setOnClickListener {
            val viewPagerIntent = Intent(this, ViewPagerActivity::class.java)
            startActivity(viewPagerIntent)
        }

    }

    private fun showAlertDialog(){
        val builder = AlertDialog.Builder(this)
            builder.setTitle("Agye muh utha ke")
                .setMessage("Kya haal chal ?")
                .setPositiveButton("Thik"){dialog, which->
                    Toast.makeText(this, "To Ham kya kare popat!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Bekar"){dialog, which->

                    dialog.dismiss()
                }
        val alertDialog : AlertDialog= builder.create()
        alertDialog.show()

    }

    //5th button    Fragments




}