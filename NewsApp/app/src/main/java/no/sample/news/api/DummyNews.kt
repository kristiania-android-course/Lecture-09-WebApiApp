package no.sample.news.api

import no.sample.news.gsontypes.Author
import no.sample.news.gsontypes.NewsStory
import no.sample.news.gsontypes.Published
import no.sample.news.gsontypes.Thumbnail


object DummyNews {

    fun getNews() : ArrayList<NewsStory>{

        var news1 = NewsStory()

        news1.title = "Vitsen med norsk rettskriving"
        news1.preamble = "Hun var alltid i politiets søkelys, jaget i by etter by, prostituert i 15 år. Hun ble drept og forsvant. Nå er Frida Grünfeld løftet fram for all ettertid, i en bok som forteller europeisk historie av sjeldent merke."
        news1.published = Published()
        news1.published.date = "tirsdag 16. mars"

        news1.authors = ArrayList<Author>()
        news1.authors.add(Author())
        news1.authors.get(0).name = "Markus Tobiassen"

        news1.url = "https://www.vg.no/nyheter/meninger/i/kJOdbA/vitsen-med-norsk-rettskriving"
        news1.thumbnail = Thumbnail()
        news1.thumbnail.url = "https://smp.vgc.no/v2/images/8629cb8c-cde0-49c2-b61a-05a188564f64?fit=crop&h=200&w=400&s=f7824fe7723f647f3224b64c437d96da28c16fea"

        var newsList = ArrayList<NewsStory> ()

        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)


        return newsList
    }
}