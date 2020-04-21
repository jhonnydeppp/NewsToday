package com.jhonnydev.newstoday.ui.news.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.mvp.ContractNews
import com.jhonnydev.newstoday.ui.news.mvp.PresenterNews
import com.jhonnydev.newstoday.utils.Utils

class NewsFragment : Fragment() , ContractNews.View {

    private var presenter: PresenterNews = PresenterNews(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getNews()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NewsFragment()
    }

    override fun showProgress(isShow: Boolean) {

    }

    override fun makeToast(msg: Int) {
        Utils.makeToast(requireContext(), getString(msg))
    }

}
