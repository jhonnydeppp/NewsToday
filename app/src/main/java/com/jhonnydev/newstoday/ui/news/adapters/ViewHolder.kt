package com.jhonnydev.newstoday.ui.news.adapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse
import com.squareup.picasso.Picasso

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTitle = view.findViewById(R.id.tv_title) as TextView
    private val tvAuthor = view.findViewById(R.id.tv_author) as TextView
    private val tvPublishedAt = view.findViewById(R.id.tv_published_at) as TextView
    private val tvDescription = view.findViewById(R.id.tv_description) as TextView
    private val tvSource = view.findViewById(R.id.tv_source) as TextView
    private val imvActicle = view.findViewById(R.id.imv_acticle) as ImageView

    fun bind(mArticlesResponse: ArticlesResponse, context : Context){
        Picasso.get().load(mArticlesResponse.urlToImage).placeholder(R.mipmap.ic_search_image).fit()
            .into(imvActicle)
        tvTitle.text = mArticlesResponse.title
        tvAuthor.text =(context.getString(R.string.author)+" "+ mArticlesResponse.author)
        tvPublishedAt.text = (context.getString(R.string.published_at)+" "+ mArticlesResponse.publishedAt)
        tvDescription.text = (context.getString(R.string.description)+" "+ mArticlesResponse.description)
        tvSource.text = (context.getString(R.string.source)+" "+ mArticlesResponse.source!!.name)
        }



}