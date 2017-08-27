package info.androidhive.materialdesign.adapter;

import com.loopj.android.http.*;

/**
 * Created by anushah on 8/26/2017.
 */

public class BooksRestClient {
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
