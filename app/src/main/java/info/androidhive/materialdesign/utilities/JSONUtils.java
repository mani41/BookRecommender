package info.androidhive.materialdesign.utilities;
import android.content.Context;
import android.content.res.Resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import info.androidhive.materialdesign.R;

/**
 * Created by akash on 8/15/17.
 */

public class JSONUtils {

    public String parseJSONData(Context context,int val) {
        String JSONString = null;
        JSONObject JSONObject = null;
        JSONArray jsonArray = null;
        try {

            //open the inputStream to the file
            Resources res = Resources.getSystem();
            InputStream inputStream = context.getResources().openRawResource(val);
            int sizeOfJSONFile = inputStream.available();
            //array that will store all the data
            byte[] bytes = new byte[sizeOfJSONFile];
            //reading data into the array from the file
            inputStream.read(bytes);
            //close the input stream
            inputStream.close();
            JSONString = new String(bytes,"UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return JSONString;
    }

}
