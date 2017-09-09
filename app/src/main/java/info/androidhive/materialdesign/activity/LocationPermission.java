package info.androidhive.materialdesign.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.utilities.AbsRuntimePermission;

/**
 * Created by Mani Shankar on 07/09/2017.
 */

public class LocationPermission extends AbsRuntimePermission {
    private static final int REQUEST_PERMISSION = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_permission);

        requestAppPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_CONTACTS},
                R.string.msg ,REQUEST_PERMISSION);
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        //Do anything when permisson granted
        Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getApplicationContext(),HomeBarter.class);
        startActivity(intent);
    }
}
