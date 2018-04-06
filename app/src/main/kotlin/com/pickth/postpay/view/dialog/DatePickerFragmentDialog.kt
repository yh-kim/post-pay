package com.pickth.postpay.view.dialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import java.text.DateFormat
import java.util.*


@SuppressLint("ValidFragment")
class DatePickerFragmentDialog(val txt: TextView) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, date: Int) {
        val c = GregorianCalendar(year, month, date)
        setDate(c)
    }

    fun setDate(c: Calendar) {
        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM)
        txt.text = dateFormat.format(c.time)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, year, month, day)
    }
}