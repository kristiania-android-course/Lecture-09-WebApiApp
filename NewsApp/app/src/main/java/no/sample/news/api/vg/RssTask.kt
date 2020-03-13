package no.sample.news.api.vg

import android.os.AsyncTask
import no.sample.news.gsontypes.Author
import no.sample.news.gsontypes.NewsStory
import no.sample.news.gsontypes.Published
import no.sample.news.gsontypes.Thumbnail
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray



class RssTask (var listener : NewsListener? ): AsyncTask<String, Any, ArrayList<NewsStory>>() {


    override fun doInBackground(vararg params: String?): ArrayList<NewsStory> {

        lateinit var newsItem : ArrayList<NewsStory>

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


    override fun onPostExecute(result: ArrayList<NewsStory>?) {

        super.onPostExecute(result)
        listener?.onNews(result)
    }


    private fun  parseIntoNewsList(json:String):ArrayList<NewsStory>
    {
        var newsList = ArrayList<NewsStory>()

        var jsonDoc = JSONArray(json)

        for (i in 0 until jsonDoc.length()) {



            val jItem = jsonDoc.getJSONObject(i)

            var story = NewsStory()


            story.url = jItem.getString("url")
            story.title = jItem.getString("title")
            story.preamble = jItem.getString("preamble")
            story.published = Published()
            story.published.date = jItem.getJSONObject("published").getString("date")

            var jAuthors = jItem.getJSONArray("authors")

            story.authors = ArrayList<Author>()
            story.authors.add(Author())

            story.authors.get(0).name =jAuthors.getJSONObject(0).getString("name")

            var thumbnail = jItem.getJSONObject("thumbnail").getString("url")

            story.thumbnail = Thumbnail()
            story.thumbnail.url = thumbnail

            newsList.add(story)

        }

        return newsList
    }



}