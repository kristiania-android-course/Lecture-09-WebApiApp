package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory

interface NewsListener {
    fun onNewsSuccess( newsList : ArrayList<NewsStory>?)
    fun onNewsError()
    fun showProgress(show : Boolean)

}