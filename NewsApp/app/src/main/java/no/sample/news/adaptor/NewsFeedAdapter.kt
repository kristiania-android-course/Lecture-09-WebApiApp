package no.sample.news.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item_layout.view.*
import no.sample.news.BuildConfig
import no.sample.news.R
import no.sample.news.datatype.NewsItem

class NewsFeedAdapter (var list: ArrayList<NewsItem> = ArrayList()) : RecyclerView.Adapter<NewsFeedAdapter.NewsViewHolder>() {

    init { // Initialization block that executes in the beginning
        Picasso.get().isLoggingEnabled = BuildConfig.DEBUG // we want to see logcat info from Picasso

        //BuildConfig.DEBUG contains your build info. it is generated on build time based on your gradle configurations
    }

    //Inflates R.layout.news_item_layout view and pass it to NewsViewHolder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
    {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item_layout, parent, false) //Inflating a ViewHolder

        return NewsViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holderNew: NewsViewHolder, position: Int) {
        holderNew.bindNewsItemWithViewHolder(list.get(position)) // Binds the data with NewsViewHolder children view
    }

    inner class NewsViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        fun bindNewsItemWithViewHolder(newsItem: NewsItem) {

            //Thanks to kotlinx.android.synthetic.main.news_item_layout.view.*
            // It has automatically declared views members inside itemView of NewsViewHolder

            itemView.texViewTitle.text = newsItem.title
            itemView.texViewPreamble.text = newsItem.preamble


            //Use of Picasso
            Picasso.get()
                .load(newsItem.thumbnail)
                .resize(100, 100)
                .centerCrop()
                .into(itemView.imageViewThumbnail)


            itemView.texViewDate.text = newsItem.publishedDate

            itemView.texViewAuthors.text= ""
            if(newsItem.authors?.isEmpty()==false) {
                itemView.texViewAuthors.text = newsItem.authors?.get(0) // There are multiple authors but we are only picking the first one :).
            }

            itemView.tag = newsItem // why we are doing this. can you tell?

        }
    }
}