package com.jhonnydev.newstoday.ui.favorites.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.adapters.NewsAdapter
import com.jhonnydev.newstoday.ui.news.adapters.ViewHolder
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse
import com.jhonnydev.newstoday.utils.PreferencesUtils
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() , ViewHolder.HolderInterface {
    private lateinit var favoritesNews: List<ArticlesResponse>
    private val mAdapter : NewsAdapter = NewsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListAndRecycler()
    }
    private fun initListAndRecycler(){
        favoritesNews = PreferencesUtils.getNewsFavoriteList()
            setUpRecyclerView(favoritesNews as MutableList<ArticlesResponse>)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            FavoritesFragment()
    }

    fun setUpRecyclerView(mArticlesList: MutableList<ArticlesResponse>){
        rv_favorites.setHasFixedSize(true)
        rv_favorites.layoutManager = LinearLayoutManager(requireContext())
        mAdapter.NewsAdapter(mArticlesList, requireContext(), this,this)
        rv_favorites.adapter = mAdapter
    }

    override fun updateRecycler() {
        Log.i("--->","actualizar"+favoritesNews)
        if (rv_favorites != null)
            initListAndRecycler()
    }
}
