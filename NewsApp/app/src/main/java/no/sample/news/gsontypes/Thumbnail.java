
package no.sample.news.gsontypes;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Thumbnail implements Parcelable
{

    private Integer width;
    private Integer height;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        public Thumbnail[] newArray(int size) {
            return (new Thumbnail[size]);
        }

    }
    ;

    protected Thumbnail(Parcel in) {
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public Thumbnail() {
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("width", width).append("height", height).append("url", url).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(width).append(additionalProperties).append(url).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Thumbnail) == false) {
            return false;
        }
        Thumbnail rhs = ((Thumbnail) other);
        return new EqualsBuilder().append(width, rhs.width).append(additionalProperties, rhs.additionalProperties).append(url, rhs.url).append(height, rhs.height).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(url);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
