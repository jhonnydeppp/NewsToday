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
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse
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

    fun saveOnFavorites(article: ArticlesResponse){
        val favoritesNews = PreferencesUtils.getNewsFavoriteList()
        if(favoritesNews.isNullOrEmpty())
            PreferencesUtils.setNewsFavoriteList(listOf(article))
        else{
            if(favoritesNews.contains(article)){
                // no hacer nada
            } else{
                val mList = favoritesNews as MutableList
                mList.add(article)
                PreferencesUtils.setNewsFavoriteList(mList)
            }
        }
    }

    fun deleteOnFavorites(article: ArticlesResponse){
        val favoritesNews = PreferencesUtils.getNewsFavoriteList()
        if(!favoritesNews.isNullOrEmpty()){
            if(favoritesNews.contains(article)){
                val mList = favoritesNews as MutableList
                mList.remove(article)
                PreferencesUtils.setNewsFavoriteList(mList)
            }
        }
    }

    fun isArticleFavorite(article: ArticlesResponse): Boolean{
        val favoritesNews = PreferencesUtils.getNewsFavoriteList()
        return if(favoritesNews.isNullOrEmpty())
            false
        else
            favoritesNews.contains(article)
    }

}