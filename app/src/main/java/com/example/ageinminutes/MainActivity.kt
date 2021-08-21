package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btnDatePicker)



        btn.setOnClickListener {view ->
            clickDatePicker(view)
//            Toast.makeText(this, "Button worked", Toast.LENGTH_SHORT).show()
        }

    }

     fun clickDatePicker(view: View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayOfMonth ->

            Toast.makeText(this, "DatePicker worked", Toast.LENGTH_SHORT).show()
            val selectedDateStr ="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            val selectedDate = findViewById<TextView>(R.id.tvSelectedDate)
            val tvDate = findViewById<TextView>(R.id.tvDateInMinutes)
            selectedDate.text = selectedDateStr

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDateStr)
            val selectedDateInMinutes = theDate!!.time / 60000 // for minute
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000
            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            tvDate.text = differenceInMinutes.toString()

        }, year, month, day).show()


    }

}

