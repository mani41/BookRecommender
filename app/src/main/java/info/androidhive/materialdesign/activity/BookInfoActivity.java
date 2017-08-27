package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.adapter.BooksRestClient;

import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;
import info.androidhive.materialdesign.controllers.BookController;
import info.androidhive.materialdesign.utilities.JSONUtils;

import org.json.JSONException;


/**
 * Created by anushah on 8/26/2017.
 */

public class BookInfoActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        try {
            search();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void search() throws JSONException {
        RequestParams params = new RequestParams("q", "goblet of fire");
        BooksRestClient.get("volumes", params, new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int code, Header[] headers, JSONObject body) {
            try {
                JSONArray itemsJson = body.getJSONArray("items");
                BookController bookController = BookController.getInstance();
                bookController.parseAPIBooks(itemsJson);
                //JSONUtils.writeToJson(getApplicationContext(), R.raw.bookinfo,jString);
                Log.d("DEBUG", itemsJson.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            super.onFailure(statusCode,headers,throwable,errorResponse);
        }
    });}

}
