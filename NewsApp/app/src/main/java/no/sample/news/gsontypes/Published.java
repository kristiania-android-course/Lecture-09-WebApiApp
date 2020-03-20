
package no.sample.news.gsontypes;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Published implements Parcelable
{

    private String datetime;
    private String niceformat;
    private String timestamp;
    private String date;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Published> CREATOR = new Creator<Published>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Published createFromParcel(Parcel in) {
            return new Published(in);
        }

        public Published[] newArray(int size) {
            return (new Published[size]);
        }

    }
    ;

    protected Published(Parcel in) {
        this.datetime = ((String) in.readValue((String.class.getClassLoader())));
        this.niceformat = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public Published() {
    }

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("datetime", datetime).append("niceformat", niceformat).append("timestamp", timestamp).append("date", date).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(date).append(datetime).append(additionalProperties).append(niceformat).append(timestamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Published) == false) {
            return false;
        }
        Published rhs = ((Published) other);
        return new EqualsBuilder().append(date, rhs.date).append(datetime, rhs.datetime).append(additionalProperties, rhs.additionalProperties).append(niceformat, rhs.niceformat).append(timestamp, rhs.timestamp).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(datetime);
        dest.writeValue(niceformat);
        dest.writeValue(timestamp);
        dest.writeValue(date);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
