package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class VgFeedClient {

    private lateinit var service :  VgService

    constructor()
    {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://www.vg.no")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(VgService::class.java)

    }

    fun getNewsFeed(newsListener: NewsListener){

        newsListener.showProgress(true)
        var call = service.getNewsFeed()

        call.enqueue(object :Callback<ArrayList<NewsStory>>{
            override fun onFailure(call: Call<ArrayList<NewsStory>>, t: Throwable) {
                newsListener.showProgress(false)

                newsListener.onNewsError()
            }

            override fun onResponse(
                call: Call<ArrayList<NewsStory>>,
                response: Response<ArrayList<NewsStory>>)
            {
                newsListener.showProgress(false)

                if(response.isSuccessful)
               {
                   newsListener.onNewsSuccess(response.body())
               }
               else
               {
                   newsListener.onNewsError()
               }
            }
        })

    }


}