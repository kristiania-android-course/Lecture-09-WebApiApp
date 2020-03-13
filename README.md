# Lecture-09-WebApiApp
This is sample Android app that consumes RSS FEED. 

App has two activities. MainActivity shows the list of the news that it fetches from https://www.vg.no/rss/feed/?format=json. 
Secondly Activity (WebViewActivity) has an embedded webview that can be opened when any news item is clicked from the MainActivity.kt 

Implementation uses AsyncTask to make web request.


|Branches|Details|
|-------|--------|
|Master| Use the live code to use during the class session|
|jsonobject| Branch uses JSONObject and JSONArray to parse the rss feed|
|gson| Branch uses GSON library to parse the rss feed|
|retrofit| Branch uses Retrofit2 library to fetch and parse the rss feed|


## Web Request Code 
        val client = OkHttpClient()

        val request: Request = Request.Builder()
                .url(url)
                .build()

        var response = client.newCall(request).execute()


## JSON Parsing with JSONArray and JSONObject

private fun  parseIntoNewsList(json:String):ArrayList<NewsStory>
    {
        var newsList = ArrayList<NewsStory>()

        var jsonDoc = JSONArray(json)

        for (i in 0 until jsonDoc.length()) {



            val jItem = jsonDoc.getJSONObject(i)

            var story = NewsStory()


            story.url = jItem.getString("url")
            story.title = jItem.getString("title")
            story.preamble = jItem.getString("preamble")
            story.published = Published()
            story.published.date = jItem.getJSONObject("published").getString("date")

            var jAuthors = jItem.getJSONArray("authors")

            story.authors = ArrayList<Author>()
            story.authors.add(Author())

            story.authors.get(0).name =jAuthors.getJSONObject(0).getString("name")

            var thumbnail = jItem.getJSONObject("thumbnail").getString("url")

            story.thumbnail = Thumbnail()
            story.thumbnail.url = thumbnail

            newsList.add(story)

        }

        return newsList
    }
    
 ## JSON Parsing with GSON Library 


    private fun  parseIntoNewsList(json:String):ArrayList<NewsStory>
    {
        var gson = Gson()

        val type = object : TypeToken<ArrayList<NewsStory>>() {}.type

        val stories = gson.fromJson< ArrayList<NewsStory> >( json,  type )


        return stories
    }




    
