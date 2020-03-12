package no.sample.news.datatype

data class NewsItem(val title:String, val preamble:String, val  publishedDate:String,
                    val url:String, val  authors:ArrayList<String>?,  val thumbnail : String? ){

}