package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory
import retrofit2.Call
import retrofit2.http.GET

interface VgService {

    @GET("/rss/feed/?format=json")
    fun getNewsFeed(): Call<ArrayList<NewsStory>>
}