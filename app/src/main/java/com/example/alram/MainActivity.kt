package com.example.alram

import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var hour: Int = 0
    private var minute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.add_button)
        val spinnerTimePicker = findViewById<TimePicker>(R.id.timePicker)

        addButton.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                hour = spinnerTimePicker.hour
                minute = spinnerTimePicker.minute

            }
            else{
                hour = spinnerTimePicker.currentHour
                minute = spinnerTimePicker.currentMinute
            }
            Toast.makeText(this, "$hour : $minute", Toast.LENGTH_SHORT).show()
        }
        val abc = SimpleDateFormat("H:m")
        Log.d("abcd",abc.parse("$hour:$minute").time.toString())
    }
}