package no.sample.news.api

import no.sample.news.datatype.NewsItem

object DummyNews {

    fun getNews() : ArrayList<NewsItem>{

        return arrayListOf(
            NewsItem("Sjef i advokatfirma slår transportfirmaet sitt konkurs",
                "Selskapet undersøkes for mulige skatteunndragelser. Styreleder og eier Afzzal Ghauri gir VG-oppslag skylden for konkursen.",
                "tirsdag 10. mars", "https://www.vg.no/nyheter/innenriks/i/wPQKxL/sjef-i-advokatfirma-slaar-transportfirmaet-sitt-konkurs", arrayListOf("Markus Tobiassen"),
                "https://smp.vgc.no/v2/images/c7991ead-71c5-4723-8ebf-eedeb6f141cc?fit=crop&h=267&w=400&s=32885e09ad32d0250383ca4bf2474c08cdb6d916"),
            NewsItem("Frp går inn for forslag om å bygge Nord-Norgebanen",
                "Frp har bestemt seg for å støtte forslaget om å be regjeringen igangsette arbeidet med å bygge jernbanen som har vært planlagt og påtenkt i over 100 år. ",
                "tirsdag 10. mars",
                "https://www.vg.no/nyheter/innenriks/i/y3MxKR/frp-gaar-inn-for-forslag-om-aa-bygge-nord-norgebanen",
                arrayListOf("Martha C. S. Holmes", ""),
                "https://imbo.vgtv.no/users/vgtv/images/3a380d219532089457ba6b05f9b99a49.jpg?t%5B%5D=320x180q80"),

        NewsItem("Frp går inn for forslag om å bygge Nord-Norgebanen",
            "Frp har bestemt seg for å støtte forslaget om å be regjeringen igangsette arbeidet med å bygge jernbanen som har vært planlagt og påtenkt i over 100 år. ",
            "tirsdag 10. mars",
            "https://www.vg.no/nyheter/innenriks/i/y3MxKR/frp-gaar-inn-for-forslag-om-aa-bygge-nord-norgebanen",
            arrayListOf("Martha C. S. Holmes", ""),
            "https://imbo.vgtv.no/users/vgtv/images/3a380d219532089457ba6b05f9b99a49.jpg?t%5B%5D=320x180q80"),


        NewsItem("Frp går inn for forslag om å bygge Nord-Norgebanen",
            "Frp har bestemt seg for å støtte forslaget om å be regjeringen igangsette arbeidet med å bygge jernbanen som har vært planlagt og påtenkt i over 100 år. ",
            "tirsdag 10. mars",
            "https://www.vg.no/nyheter/innenriks/i/y3MxKR/frp-gaar-inn-for-forslag-om-aa-bygge-nord-norgebanen",
            arrayListOf("Martha C. S. Holmes", ""),
            "https://imbo.vgtv.no/users/vgtv/images/3a380d219532089457ba6b05f9b99a49.jpg?t%5B%5D=320x180q80"),
        NewsItem("Frp går inn for forslag om å bygge Nord-Norgebanen",
            "Frp har bestemt seg for å støtte forslaget om å be regjeringen igangsette arbeidet med å bygge jernbanen som har vært planlagt og påtenkt i over 100 år. ",
            "tirsdag 10. mars",
            "https://www.vg.no/nyheter/innenriks/i/y3MxKR/frp-gaar-inn-for-forslag-om-aa-bygge-nord-norgebanen",
            arrayListOf("Martha C. S. Holmes", ""),
            "https://imbo.vgtv.no/users/vgtv/images/3a380d219532089457ba6b05f9b99a49.jpg?t%5B%5D=320x180q80"))


    }
}