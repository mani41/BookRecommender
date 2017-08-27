package info.androidhive.materialdesign.controllers;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.materialdesign.model.BookInfoModel;



/**
 * Created by anushah on 8/26/17.
 */

public class BookController {
    private List<BookInfoModel> suggestedMatches;
    private static BookController instance = null;
    private Context context = null;

    private BookController(){
    }

    public static BookController getInstance(){
        if(instance == null){
            instance = new BookController();
        }
        return instance;
    }

    public List<BookInfoModel> parseAPIBooks(JSONArray booksArray) throws JSONException, JsonProcessingException {
        List<BookInfoModel> bookInfoModel = new ArrayList<BookInfoModel>();
        String id = "";
        String title = "";
        String subtitle = "";
        List<String> authors = null;
        String publishedDate = "";
        String description = "";
        List<Map<String,String>> industryIdentifiers = null;
        int pageCount = 0;
        float avgRatingGoogle = 0;
        int ratingCount = 0;
        List<String> categories = null;
        List<Map<String,String>> imageLinks = null;
        String previewLink = "";
        Map<String,String> searchInfo = null;
        for( int i = 0; i < booksArray.length(); i++ ){
            JSONObject book = booksArray.getJSONObject(i);
            id = book.has("id") ? book.getString("id") : "";
            JSONObject volumeInfo = book.has("volumeInfo") ? book.getJSONObject("volumeInfo") : null;
            if (volumeInfo != null){
                title = volumeInfo.has("title") ? volumeInfo.getString("title") : "";
                subtitle = volumeInfo.has("subtitle") ? volumeInfo.getString("subtitle") : "";
                JSONArray jsonauthors = volumeInfo.has("authors") ? volumeInfo.getJSONArray("authors") : null ;
                authors =  new ArrayList<String>();
                if(jsonauthors != null){
                    for (int j = 0; j < jsonauthors.length(); j++) {
                        String author = jsonauthors.getString(j);
                        authors.add(author);
                    }
                }
                JSONArray jsonindustryidentifiers = volumeInfo.has("industryIdentifiers") ? volumeInfo.getJSONArray("industryIdentifiers") : null;
                industryIdentifiers  = new ArrayList<Map<String,String>>();
                if (jsonindustryidentifiers != null){
                    for (int j = 0; j< jsonindustryidentifiers.length(); j++){
                        JSONObject obj = jsonindustryidentifiers.getJSONObject(j);
                        Map<String,String> map = new HashMap<String,String>();
                        map.put(obj.get("type").toString(),obj.get("identifier").toString());
                        industryIdentifiers.add(map);
                    }
                }
                JSONObject jsonimagelinks = volumeInfo.has("imageLinks") ? volumeInfo.getJSONObject("imageLinks") : null;
                imageLinks  = new ArrayList<Map<String,String>>();
                if (jsonimagelinks != null) {
                    for (int j = 0; j < jsonimagelinks.length(); j++){
                        Map<String,String> map = new HashMap<String,String>();
                        map.put("smallThumbnail",jsonimagelinks.get("smallThumbnail").toString());
                        map.put("thumbnail", jsonimagelinks.get("thumbnail").toString());
                        imageLinks.add(map);
                    }
                }

                JSONObject jsonsearchinfo = volumeInfo.has("searchInfo") ? volumeInfo.getJSONObject("searchInfo") : null;
                searchInfo  = new HashMap<String, String>();
                if (jsonsearchinfo != null){
                    searchInfo.put("textSnippet", jsonsearchinfo.get("textSnippet").toString());
                }

                publishedDate = volumeInfo.has("publishedDate") ? volumeInfo.getString("publishedDate") : "";
                description = volumeInfo.has("description") ? volumeInfo.getString("description") : "";
                pageCount = volumeInfo.has("pageCount") ? volumeInfo.getInt("pageCount") : 0;
                avgRatingGoogle = volumeInfo.has("averageRating") ? (float) volumeInfo.getDouble("averageRating") : 0.0f;
                ratingCount = volumeInfo.has("ratingsCount") ? volumeInfo.getInt("ratingsCount") : 0;
                JSONArray jsoncategories = volumeInfo.has("categories") ? volumeInfo.getJSONArray("categories") : null ;
                categories = new ArrayList<String>();
                if (jsoncategories != null){
                    for (int j = 0; j < jsoncategories.length(); j++) {
                        JSONObject category = jsoncategories.getJSONObject(j);
                        categories.add(category.toString());
                    }
                }

                previewLink = volumeInfo.has("previewLink") ? volumeInfo.getString("previewLink") : "";
            }

            BookInfoModel bookInfo = new BookInfoModel(id, title, subtitle, authors, publishedDate, description, industryIdentifiers, pageCount, avgRatingGoogle, ratingCount, categories, imageLinks, previewLink, searchInfo);

            bookInfoModel.add(bookInfo);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String bookInfoModelString = objectMapper.writeValueAsString(bookInfoModel);
        Log.d("Tag",bookInfoModelString);

        return bookInfoModel;
    }

}
