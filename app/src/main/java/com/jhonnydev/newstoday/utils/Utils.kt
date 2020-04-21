package com.jhonnydev.newstoday.utils

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.widget.Toast
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import java.io.InputStream
import java.net.URL
import android.util.Base64
import android.util.Log

import android.webkit.MimeTypeMap
import com.google.android.material.snackbar.Snackbar
import com.jhonnydev.newstoday.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    private val TAG = javaClass.simpleName

    fun makeToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun makeSnackBar(view: View, msg: String) {
        val snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)

        val snack_view = snackbar.view

        val snack_text_view = snack_view
            .findViewById<TextView>(R.id.snackbar_text)

        snack_view.setBackgroundColor(Color.parseColor("#FF5A60"))
        snack_text_view.setTextColor(Color.WHITE)

        snackbar.show()
    }

}