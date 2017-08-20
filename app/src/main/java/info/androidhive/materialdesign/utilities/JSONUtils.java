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

    public String parseJSONData(Context context) {
        String JSONString = null;
        JSONObject JSONObject = null;
        JSONArray jsonArray = null;
        try {

            //open the inputStream to the file
            int fd = R.raw.users;
            Resources res = Resources.getSystem();
            //InputStream inputStream = Resources.getSystem().getAssets().open("raw\\users.json");
            InputStream inputStream = context.getResources().openRawResource(R.raw.users);

            int sizeOfJSONFile = inputStream.available();

            //array that will store all the data
            byte[] bytes = new byte[sizeOfJSONFile];

            //reading data into the array from the file
            inputStream.read(bytes);

            //close the input stream
            inputStream.close();

            JSONString = new String(bytes);
            //JSONObject = new JSONObject(JSONString);
            jsonArray = new JSONArray(JSONString);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (JSONException x) {
            x.printStackTrace();
            return null;
        }
        return JSONString;
    }

}
