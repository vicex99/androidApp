package com.utad.misapuntesclase.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.widget.DatePicker

import com.utad.misapuntesclase.models.UserData
import java.text.SimpleDateFormat
import java.util.*

class CalendaryDateFragment : DatePickerDialog.OnDateSetListener, DialogFragment() {

    private lateinit var myUserData: UserData
    internal var selectedDate = MutableLiveData<Date>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        myUserData = UserData.getInstance()
        Log.d("qqqqqqq2", "entrooooooooooooooooooooooooo")
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity!!, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val df = SimpleDateFormat("dd MM yyyy")
        val date = df.parse("$day $month $year")

        myUserData.date = date
        selectedDate.value =  date
    }
}
