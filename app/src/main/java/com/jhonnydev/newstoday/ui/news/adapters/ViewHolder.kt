package com.jhonnydev.newstoday.ui.news.adapters

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jhonnydev.newstoday.MainActivity
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse
import com.jhonnydev.newstoday.ui.news.view.NewsFragment
import com.jhonnydev.newstoday.utils.Utils
import com.squareup.picasso.Picasso

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTitle = view.findViewById(R.id.tv_title) as TextView
    private val tvAuthor = view.findViewById(R.id.tv_author) as TextView
    private val tvPublishedAt = view.findViewById(R.id.tv_published_at) as TextView
    private val tvDescription = view.findViewById(R.id.tv_description) as TextView
    private val tvSource = view.findViewById(R.id.tv_source) as TextView
    private val imvActicle = view.findViewById(R.id.imv_acticle) as ImageView
    private val clItem = view.findViewById(R.id.cl_item) as ConstraintLayout
    private val imvFavorite = view.findViewById(R.id.imv_favorite) as ImageView


    fun bind(mArticlesResponse: ArticlesResponse, context : Context, currentFragment: Fragment){
        Picasso.get().load(mArticlesResponse.urlToImage).placeholder(R.mipmap.ic_search_image).fit()
            .into(imvActicle)
        tvTitle.text = mArticlesResponse.title
        tvAuthor.text =(context.getString(R.string.author)+" "+ mArticlesResponse.author)
        tvPublishedAt.text = (context.getString(R.string.published_at)+" "+ mArticlesResponse.publishedAt)
        tvDescription.text = (context.getString(R.string.description)+" "+ mArticlesResponse.description)
        tvSource.text = (context.getString(R.string.source)+" "+ mArticlesResponse.source!!.name)
        
        Utils.isArticleFavorite(mArticlesResponse)
        imvFavorite.setImageResource(R.mipmap.ic_is_favorite)

        val isNewsFragment :Boolean = try {
            val aux :NewsFragment = currentFragment as NewsFragment
            true
        }catch (e: ClassCastException){
            false
        }



        clItem.setOnClickListener{
            val bundle = bundleOf("url" to mArticlesResponse.url)
            if(isNewsFragment)
                currentFragment.findNavController().navigate(R.id.action_navigation_home_to_notice_fragment,bundle)
            else
                currentFragment.findNavController().navigate(R.id.action_navigation_dashboard_to_notice_fragment,bundle)
        }
        }



}