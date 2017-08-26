package info.androidhive.materialdesign.model;

import java.util.List;
import java.util.Map;

/**
 * Created by akash on 8/26/17.
 * stores all the data related to a book
 */

public class BookInfoModel {
    private String id;
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publishedDate;
    private String description;
    private List<Map<String,String>> industryIdentifier;
    private int pageCount;
    private float avgRatingGoogle;
    private int ratingCount;
    private List<String> categories;
    private List<Map<String,String>> imageLinks;
    private String previewLink;
    private Map<String,String> searchInfo;


    public BookInfoModel() {
    }

    public BookInfoModel(String id, String title, String subtitle, List<String> authors, String publishedDate, String description, List<Map<String, String>> industryIdentifier, int pageCount, float avgRatingGoogle, int ratingCount, List<String> categories, List<Map<String, String>> imageLinks, String previewLink, Map<String, String> searchInfo) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifier = industryIdentifier;
        this.pageCount = pageCount;
        this.avgRatingGoogle = avgRatingGoogle;
        this.ratingCount = ratingCount;
        this.categories = categories;
        this.imageLinks = imageLinks;
        this.previewLink = previewLink;
        this.searchInfo = searchInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Map<String, String>> getIndustryIdentifier() {
        return industryIdentifier;
    }

    public void setIndustryIdentifier(List<Map<String, String>> industryIdentifier) {
        this.industryIdentifier = industryIdentifier;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public float getAvgRatingGoogle() {
        return avgRatingGoogle;
    }

    public void setAvgRatingGoogle(float avgRatingGoogle) {
        this.avgRatingGoogle = avgRatingGoogle;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Map<String, String>> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<Map<String, String>> imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public Map<String, String> getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(Map<String, String> searchInfo) {
        this.searchInfo = searchInfo;
    }
}
