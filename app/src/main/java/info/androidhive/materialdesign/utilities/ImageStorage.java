package info.androidhive.materialdesign.utilities;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Mani Shankar on 26-08-2017.
 */

public class ImageStorage {
    static final String appDirectoryName = "MaterialDesign";
    static final File imageRoot = new File(Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES), appDirectoryName);


    public static void saveToInternalStorage(Bitmap bitmapImg) {

        if (!imageRoot.exists()) {
            imageRoot.mkdir();
        }
        //File imageFile = new File(imageRoot.toString() + bitmapImg + ".jpg");
        // File image = new File(imageRoot, "image1.jpg");
        File mypath = new File(imageRoot, "profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            bitmapImg.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            Log.e("SAVE_IMAGE", e.getMessage(), e);
        }
    }

    public static String getImageDirectory() {
        return imageRoot.toString();
    }
}
