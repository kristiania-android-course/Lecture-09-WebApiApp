package no.sample.news.api.vg

import android.os.AsyncTask
import no.sample.news.datatype.NewsItem
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray



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
        var newsList = ArrayList<NewsItem>()

        var jsonDoc = JSONArray(json)

        for (i in 0 until jsonDoc.length()) {

            val jItem = jsonDoc.getJSONObject(i)

            var url = jItem.getString("url")
            var title = jItem.getString("title")
            var preamble = jItem.getString("preamble")
            var date = jItem.getJSONObject("published").getString("date")
            var authors = ArrayList<String>()
            var thumbnail = jItem.getJSONObject("thumbnail").getString("url")

            var jAuthors = jItem.getJSONArray("authors")

            for (j in 0 until jAuthors.length()){
                authors.add(jAuthors.getJSONObject(j).getString("name"))
            }

            newsList.add(NewsItem(title,preamble, date, url, authors, thumbnail))

        }

        return newsList
    }



}