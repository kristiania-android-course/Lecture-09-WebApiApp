
package no.sample.news.gsontypes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsStory {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("published")
    @Expose
    private Published published;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("persistentUrl")
    @Expose
    private String persistentUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("preamble")
    @Expose
    private String preamble;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
    @SerializedName("mainCategory")
    @Expose
    private String mainCategory;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;

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

}
