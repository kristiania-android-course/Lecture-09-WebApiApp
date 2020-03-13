package no.sample.news.api.vg

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import no.sample.news.gsontypes.NewsStory

import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception


class RssTask (var listener : NewsListener? ): AsyncTask<String, Any, ArrayList<NewsStory>>() {


    override fun doInBackground(vararg params: String?): ArrayList<NewsStory> {

        publishProgress(0)

        try {
            lateinit var newsItem : ArrayList<NewsStory>

            var jsonResponse = callWebRequest(params.get(0)!!)
            newsItem = parseIntoNewsList(jsonResponse)

            return newsItem
        }
        catch (ex:Exception){
            ex.printStackTrace()
        }


        return arrayListOf()

    }

    override fun onProgressUpdate(vararg values: Any?) {
        super.onProgressUpdate(*values)

        listener?.showProgress(true)
    }

    override fun onPostExecute(result: ArrayList<NewsStory>) {


        super.onPostExecute(result)

        listener?.showProgress(false)

        if(result.isEmpty()){
            listener?.onNewsError()
        }
        else
        {
            listener?.onNewsSuccess(result)
        }

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





    private fun  parseIntoNewsList(json:String):ArrayList<NewsStory>
    {
        var gson = Gson()

        val type = object : TypeToken<ArrayList<NewsStory>>() {}.type

        val stories = gson.fromJson< ArrayList<NewsStory> >( json,  type )


        return stories
    }



}