package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory
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

    fun getNewsFeed(): ArrayList<NewsStory>{

        var call = service.getNewsFeed()
        var response =  call.execute()

        if(response.isSuccessful) {
            return response.body()!!
        }

        return arrayListOf()
    }


}