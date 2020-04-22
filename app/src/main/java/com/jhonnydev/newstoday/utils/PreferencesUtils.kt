package com.jhonnydev.newstoday.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse


object PreferencesUtils {
    private val TAG = PreferencesUtils::class.java.simpleName

    private var mSharedPref: SharedPreferences? = null

    fun init(context: Context) {
        if (mSharedPref == null) {
            mSharedPref = context.getSharedPreferences(TAG, Activity.MODE_PRIVATE)
        }
    }

    fun clearPreference() {
        mSharedPref!!.edit().clear().apply()
    }

    fun clearSinglePreference(key:String){
        mSharedPref!!.edit().remove(key).apply()
    }


    fun setNewsFavoriteList(apkList: List<ArticlesResponse>) {
        val gson = Gson()
        val json = gson.toJson(apkList)
        val editor = mSharedPref!!.edit()
        editor.putString(KeyPreferences.PREF_KEY_FAVORITES_LIST.value, json.toString())
        editor.apply()

    }

    fun getNewsFavoriteList(): List<ArticlesResponse> {
        val gson = Gson()
        val jsonPreferences = mSharedPref!!.getString(KeyPreferences.PREF_KEY_FAVORITES_LIST.value, "")
        return if(jsonPreferences.isNullOrEmpty())
            emptyList()
        else
            gson.fromJson(jsonPreferences, object : TypeToken<List<ArticlesResponse>>() {}.type)
    }

}