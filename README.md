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
