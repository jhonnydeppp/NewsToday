package com.jhonnydev.newstoday.ui.notice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.jhonnydev.newstoday.R
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse
import com.jhonnydev.newstoday.utils.PreferencesUtils
import com.jhonnydev.newstoday.utils.Utils
import kotlinx.android.synthetic.main.fragment_notice.*


class NoticeFragment : Fragment() ,Toolbar.OnMenuItemClickListener{

    private var url: String? = null

    private var article: ArticlesResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString("url")
            article = PreferencesUtils.getCurrentArticle()
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
        //Log.i("--->","url: "+url)

        initToolbar()
        if(!url.isNullOrEmpty())
            ww_notice.loadUrl(url)
    }

    private fun initToolbar(){
        toolbar_notice.setNavigationIcon(R.mipmap.ic_back_arrow)
        toolbar_notice.setNavigationOnClickListener(View.OnClickListener {
            requireActivity().onBackPressed()
        })
        toolbar_notice.setTitle("Notice")
        //toolbar_notice.second
        toolbar_notice.inflateMenu(R.menu.menu_toolbar)
        toolbar_notice.setOnMenuItemClickListener(this)


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NoticeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
         when (item!!.itemId) {
            R.id.add_to_favorite -> {
                Log.i("item id ", item!!.itemId.toString() + " addddddddddddd ")
                if(article !=null)
                    Utils.saveOnFavorites(article!!)
                super.onOptionsItemSelected(item!!)
            }
             R.id.remove_from_favorites->{
                 if(article != null)
                 Utils.deleteOnFavorites(article!!)
                 Log.i("item id ", item!!.itemId.toString() + " deleteeeeeeeeb ")
             }
            else -> super.onOptionsItemSelected(item!!)
        }
        return true
    }


}


