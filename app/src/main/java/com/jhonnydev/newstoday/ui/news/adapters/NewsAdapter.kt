package com.jhonnydev.newstoday.ui.news.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse

class NewsAdapter : RecyclerView.Adapter<ViewHolder>() {
    var mArticlesList: MutableList<ArticlesResponse>  = ArrayList()
    lateinit var context:Context
    lateinit var currentFragment: Fragment
    var mInterface: ViewHolder.HolderInterface? = null

    fun NewsAdapter(mArticlesList: MutableList<ArticlesResponse>, context: Context
                    ,currentFragment: Fragment, mInterface: ViewHolder.HolderInterface?) {
        this.mArticlesList = mArticlesList
        this.context = context
        this.currentFragment = currentFragment
        this.mInterface = mInterface
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mArticlesList.get(position)
        holder.bind(item,context,currentFragment,mInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_recycler_news, parent, false))
    }

    override fun getItemCount(): Int {
        return mArticlesList.size
    }

}