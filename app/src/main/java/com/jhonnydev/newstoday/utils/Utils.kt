package com.jhonnydev.newstoday.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse


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

    fun boldStart(cadena :String): SpannableString{
        var indice: Int = 0
        val miTexto = SpannableString(cadena)
        val boldSpan1 = StyleSpan(Typeface.BOLD)
        val fisrtString: String = cadena.substring(0, cadena.indexOf(' '))
        indice = fisrtString.length
        miTexto.setSpan(boldSpan1, 0, indice, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        return miTexto
    }

}