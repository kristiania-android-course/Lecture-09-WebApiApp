package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VgService {

    @GET("/rss/feed/") // Using annotation for the endpoint
    fun getNewsFeed(@Query("format") format: String, @Query("limit") limit: Int ): Call<ArrayList<NewsStory>>


}