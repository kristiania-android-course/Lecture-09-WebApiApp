package no.sample.news.api.vg

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import no.sample.news.datatype.NewsItem
import no.sample.news.gsontypes.NewsStory
import okhttp3.OkHttpClient
import okhttp3.Request


class RssTask (var listener : NewsListener? ): AsyncTask<String, Any, ArrayList<NewsItem>?>() {

    override fun doInBackground(vararg params: String?): ArrayList<NewsItem>? {

        var stories =  VgFeedClient().getNewsFeed()

        var newsItems = ArrayList<NewsItem>()

        for( i in 0 until stories.size ){

            var story  = stories.get(i)
            var authors = story.authors?.map { it.name }
            var thumbnailUrl = story?.thumbnail?.url

            newsItems. add (NewsItem(story.title, story.preamble, story.published.date, story.url,  authors as ArrayList<String> , thumbnailUrl))

        }

        return newsItems
    }


    override fun onPostExecute(result: ArrayList<NewsItem>?) {

        super.onPostExecute(result)
        listener?.onNews(result)
    }

}