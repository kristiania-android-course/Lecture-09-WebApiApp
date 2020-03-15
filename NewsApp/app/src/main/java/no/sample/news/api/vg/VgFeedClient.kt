package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class VgFeedClient {

    private lateinit var service :  VgService // This is service interface

    constructor()
    {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://www.vg.no") // Base URL for the endpoint
            .addConverterFactory(GsonConverterFactory.create()) // Using GSON Converter which will automatically handles parsing
            .build()

        service = retrofit.create(VgService::class.java)

    }

    fun getNewsFeed( newsListener: NewsListener )
    {

        newsListener.showProgress(true) // showing progress via callback

        var call = service.getNewsFeed("json", 10) // supplying the query parameters in the call

        call.enqueue(object :Callback<ArrayList<NewsStory>>  // Calling the endpoint asynchronously
        {
            override fun onFailure(call: Call<ArrayList<NewsStory>>, t: Throwable) { // Handling failure
                newsListener.showProgress(false) // ending progress. onFailure is called in primary thread

                newsListener.onNewsError() // UI will show error message
            }

            override fun onResponse( call: Call<ArrayList<NewsStory>>, response: Response<ArrayList<NewsStory>>) {
                newsListener.showProgress(false) // ending progress. onResponse is called in primary thread

               if(response.isSuccessful) // if the response is successful
               {
                   newsListener.onNewsSuccess(response.body()) // give back the ArrayList<NewsStory> to UI via
               }
               else
               {
                   newsListener.onNewsError() // UI will show error message
               }
            }
        })

    }


}