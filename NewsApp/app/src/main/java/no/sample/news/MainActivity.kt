package no.sample.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import no.sample.news.adaptor.NewsFeedAdapter
import no.sample.news.api.DummyNews
import no.sample.news.datatype.NewsItem

class MainActivity : AppCompatActivity() {

    var newsEndpoint = "https://www.vg.no/rss/feed/?format=json" // web api link

    lateinit var adapter: NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        //Setting up recyclerView view
        adapter = NewsFeedAdapter() // Empty adapter
        recyclerView.layoutManager = LinearLayoutManager(this) // We want the list to be linear & vertical list
        recyclerView.adapter = adapter // associating the adapter with recyclerView

        updateNews(DummyNews.getNews()) // getting dummy feed for layout implementation

    }

    // Refreshing the news feed
    private fun updateNews( feed: ArrayList<NewsItem>) {
        adapter.list = feed // setting new feed ArrayList
        adapter.notifyDataSetChanged() // This notifies the adapter that data has changed. RecyclerView needs refresh
    }

}
