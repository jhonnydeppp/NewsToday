package com.jhonnydev.newstoday.ui.notice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jhonnydev.newstoday.R
import kotlinx.android.synthetic.main.fragment_notice.*



class NoticeFragment : Fragment() {

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString("url")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("--->","url: "+url)
        if(!url.isNullOrEmpty())
            ww_notice.loadUrl(url)

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NoticeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
