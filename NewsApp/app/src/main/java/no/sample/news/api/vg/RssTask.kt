package no.sample.news.api.vg

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import no.sample.news.gsontypes.NewsStory

import okhttp3.OkHttpClient
import okhttp3.Request


class RssTask (var listener : NewsListener? ): AsyncTask<String, Any, ArrayList<NewsStory>>() {

    override fun doInBackground(vararg params: String?): ArrayList<NewsStory>? {
        var stories =  VgFeedClient().getNewsFeed()
        return stories
    }

    override fun onPostExecute(result: ArrayList<NewsStory>?) {

        super.onPostExecute(result)
        listener?.onNews(result)
    }
}