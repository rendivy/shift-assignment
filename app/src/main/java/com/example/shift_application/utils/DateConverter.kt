package com.example.shift_application.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object DateConverter {
    fun convertDateToString (millis: Long, locale: Locale = Locale.getDefault()): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy", locale)
        sdf.timeZone =
            TimeZone.getTimeZone("UTC")
        val date = Date(millis)
        return sdf.format(date)
    }
}