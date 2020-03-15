package no.sample.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import no.sample.news.adaptor.NewsFeedAdapter
import no.sample.news.api.vg.NewsListener
import no.sample.news.api.vg.VgFeedClient
import no.sample.news.api.vg.VgService
import no.sample.news.utils.Utils
import no.sample.news.gsontypes.NewsStory


class MainActivity : AppCompatActivity(), View.OnClickListener, NewsListener {

    var newsEndpoint = "https://www.vg.no/rss/feed/?format=json" // web api link

    lateinit var adapter: NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //Setting up recyclerView view
        adapter = NewsFeedAdapter() // Empty adapter
        recyclerView.layoutManager = LinearLayoutManager(this) // We want the list to be linear & vertical list
        recyclerView.adapter = adapter // associating the adapter with recyclerView

        adapter.onClickListener = this // clicking listening interface association


        if( Utils.isNetworkAvailable(this)) {
           VgFeedClient().getNewsFeed(this)
        }
        else {
            Toast.makeText(this, getString(R.string.no_connection_message), Toast.LENGTH_LONG).show()
        }
    }


    // Refreshing the news feed

    private fun updateNews( feed: ArrayList<NewsStory>) {

        if(isFinishing){
            return
        }

        adapter.list = feed // setting new feed ArrayList
        adapter.notifyDataSetChanged() // This notifies the adapter that data has changed. RecyclerView needs refresh
    }


    override fun onClick(v: View?) {

        var newsItem = v?.tag as NewsStory

        Intent(this, WebViewActivity::class.java).also {intent->
            intent.putExtra(WebViewActivity.LINK,newsItem.url)
            startActivity(intent)
        }

    }

    override fun onNewsSuccess(newsList: ArrayList<NewsStory>?) {

        if(isFinishing){
            return
        }
        updateNews(newsList!!)
    }

    override fun onNewsError() {
        Toast.makeText(this, getString(R.string.news_fetch_error), Toast.LENGTH_LONG).show()
    }

    override fun showProgress(show: Boolean) {

        if( isFinishing ){
            return
        }

        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }
}
