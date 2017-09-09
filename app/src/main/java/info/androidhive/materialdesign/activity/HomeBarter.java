package info.androidhive.materialdesign.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.utilities.AbsRuntimePermission;
import info.androidhive.materialdesign.utilities.ImageStorage;

/**
 * Created by Mani Shankar on 07/09/2017.
 */


public class HomeBarter extends AbsRuntimePermission {
    private static final int CAMERA_REQUEST = 1888;
    private static final int REQUEST_PERMISSION = 10;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_permission);

        requestAppPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_CONTACTS},
                R.string.msg ,REQUEST_PERMISSION);

        //this.imageView = (ImageView)this.findViewById(R.id.BookPhotoId);
        Button photoButton = (Button) this.findViewById(R.id.barterB);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageStorage.saveToInternalStorage(photo);
            Intent intent=new Intent(getApplicationContext(),CurrentBookInfo.class);
            startActivity(intent);
            //imageView.setImageBitmap(photo);
        }
    }

}
