package no.sample.news.api.vg

import no.sample.news.datatype.NewsItem

interface NewsListener {
    fun onNews( newsList : ArrayList<NewsItem>?)
}