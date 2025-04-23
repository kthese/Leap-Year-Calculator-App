package com.example.leapyearcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val isLeap = findViewById<TextView>(R.id.isLeapOrNot)
        val input = findViewById<EditText>(R.id.editTextNumber)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        calculateBtn.setOnClickListener{

            val year = input.text.toString()

            if (year.isEmpty()){
                Toast.makeText(this, "Value is empty.", Toast.LENGTH_SHORT).show()
            } else {
                val yearNum = year.toInt()

                if (yearNum % 4 == 0 && yearNum % 100 != 0){ //divisible by 4 and not 100
                    isLeap.text = "LEAP YEAR"
                } else if (yearNum % 4 == 0 && yearNum % 100 == 0) { //divisible by 4 and 100 is not a leap year
                    isLeap.text = "NOT A LEAP YEAR"
                } else {
                    isLeap.text = "NOT A LEAP YEAR"
                }
            }
        }

        clearBtn.setOnClickListener{
            isLeap.text = "LEAP YEAR OR NOT"
            input.text.clear()
        }

        exitBtn.setOnClickListener{
            finishAffinity()
        }
    }
}