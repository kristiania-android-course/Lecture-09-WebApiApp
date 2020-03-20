package no.sample.news.api.vgapi

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import no.sample.news.gsontypes.Author
import no.sample.news.gsontypes.NewsStory
import no.sample.news.gsontypes.Published
import no.sample.news.gsontypes.Thumbnail
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject

class RssTask(var listener: NewsListener?) : AsyncTask<String /*Input*/, Int /*Update unit*/, ArrayList<NewsStory>> /*Result*/()
{


    override fun doInBackground(vararg params: String): ArrayList<NewsStory> {

        lateinit var newsItem: ArrayList<NewsStory>

        publishProgress(0)

        try {
            var jsonStr = callWebRequest(params.get(0))

            newsItem = parseIntoNewsList(jsonStr)

            publishProgress(100)

        }
        catch (ex:Exception){
            ex.printStackTrace()
        }

        return newsItem
    }

    override fun onPostExecute(result: ArrayList<NewsStory>) {

        super.onPostExecute(result)

        if(result.isEmpty()){
            listener?.onNewsError()
        }
        else
        {
            listener?.onNewsSuccess(result)
        }
    }


    private fun parseIntoNewsList(jsonStr: String): ArrayList<NewsStory> {

        val type = object : TypeToken<ArrayList<NewsStory>>() {}.type


        val stories = Gson().fromJson<ArrayList<NewsStory>>(jsonStr, type )

        return stories
    }


    private fun callWebRequest(url: String): String {
        val client = OkHttpClient()

        val request: Request = Request.Builder()
            .url(url)
            .build()

        var response = client.newCall(request).execute()

        return response.body!!.string()
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)

        if(values.get(0) == 0)
        {
            listener?.showProgress(true)
        }
        else
        {
           listener?.showProgress(false)
        }


    }


}