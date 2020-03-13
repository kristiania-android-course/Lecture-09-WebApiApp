
package no.sample.news.gsontypes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Published {

    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("niceformat")
    @Expose
    private String niceformat;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("date")
    @Expose
    private String date;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNiceformat() {
        return niceformat;
    }

    public void setNiceformat(String niceformat) {
        this.niceformat = niceformat;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
