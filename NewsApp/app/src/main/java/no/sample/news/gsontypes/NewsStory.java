
package no.sample.news.gsontypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class NewsStory implements Parcelable
{

    private String id;
    private Published published;
    private String url;
    private String persistentUrl;
    private String title;
    private String preamble;
    private List<Author> authors = null;
    private String mainCategory;
    private List<Category> categories = null;
    private Thumbnail thumbnail;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<NewsStory> CREATOR = new Creator<NewsStory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NewsStory createFromParcel(Parcel in) {
            return new NewsStory(in);
        }

        public NewsStory[] newArray(int size) {
            return (new NewsStory[size]);
        }

    }
    ;

    protected NewsStory(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.published = ((Published) in.readValue((Published.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.persistentUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.preamble = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.authors, (Author.class.getClassLoader()));
        this.mainCategory = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.categories, (Category.class.getClassLoader()));
        this.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public NewsStory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Published getPublished() {
        return published;
    }

    public void setPublished(Published published) {
        this.published = published;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPersistentUrl() {
        return persistentUrl;
    }

    public void setPersistentUrl(String persistentUrl) {
        this.persistentUrl = persistentUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("published", published).append("url", url).append("persistentUrl", persistentUrl).append("title", title).append("preamble", preamble).append("authors", authors).append("mainCategory", mainCategory).append("categories", categories).append("thumbnail", thumbnail).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(preamble).append(thumbnail).append(mainCategory).append(id).append(published).append(categories).append(additionalProperties).append(title).append(url).append(persistentUrl).append(authors).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NewsStory) == false) {
            return false;
        }
        NewsStory rhs = ((NewsStory) other);
        return new EqualsBuilder().append(preamble, rhs.preamble).append(thumbnail, rhs.thumbnail).append(mainCategory, rhs.mainCategory).append(id, rhs.id).append(published, rhs.published).append(categories, rhs.categories).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).append(url, rhs.url).append(persistentUrl, rhs.persistentUrl).append(authors, rhs.authors).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(published);
        dest.writeValue(url);
        dest.writeValue(persistentUrl);
        dest.writeValue(title);
        dest.writeValue(preamble);
        dest.writeList(authors);
        dest.writeValue(mainCategory);
        dest.writeList(categories);
        dest.writeValue(thumbnail);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
