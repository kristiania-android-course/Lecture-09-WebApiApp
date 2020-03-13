package no.sample.news.api.vg

import no.sample.news.gsontypes.NewsStory

interface NewsListener {
    fun onNews( newsList : ArrayList<NewsStory>?)
}