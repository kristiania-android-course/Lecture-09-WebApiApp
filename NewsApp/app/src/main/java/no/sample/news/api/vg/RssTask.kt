package no.sample.news.api.vg

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import no.sample.news.datatype.NewsItem
import no.sample.news.gsontypes.NewsStory
import okhttp3.OkHttpClient
import okhttp3.Request


class RssTask (var listener : NewsListener? ): AsyncTask<String, Any, ArrayList<NewsItem>>() {


    override fun doInBackground(vararg params: String?): ArrayList<NewsItem> {

        lateinit var newsItem : ArrayList<NewsItem>

        var jsonResponse = callWebRequest(params.get(0)!!)
        newsItem = parseIntoNewsList(jsonResponse)

        return newsItem
    }

    private fun callWebRequest(url: String): String
    {
        val client = OkHttpClient()

        val request: Request = Request.Builder()
                .url(url)
                .build()

        var response = client.newCall(request).execute()

        return response.body!!.string()
    }


    override fun onPostExecute(result: ArrayList<NewsItem>?) {

        super.onPostExecute(result)
        listener?.onNews(result)
    }


    private fun  parseIntoNewsList(json:String):ArrayList<NewsItem>
    {
        var gson = Gson()


        val type = object : TypeToken<ArrayList<NewsStory>>() {}.type
        val stories = gson.fromJson<ArrayList<NewsStory>>(json, type)

        var newsItems = ArrayList<NewsItem>()

        for( i in 0 until stories.size ){

            var story  = stories.get(i)

            var authors = story.authors?.map { it.name }

            var thumbnailUrl = story?.thumbnail?.url

            newsItems. add (NewsItem(story.title, story.preamble, story.published.date, story.url,  authors as ArrayList<String> , thumbnailUrl))

        }

        return newsItems
    }



}