package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.File;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.controllers.UserController;
import info.androidhive.materialdesign.utilities.ImageStorage;
/**
 * Created by Mani Shankar on 26-08-2017.
 */
public class CurrentBookInfo extends AppCompatActivity {

    private ImageView currentImage;
    private EditText bookName;
    private EditText bookAge;
    private EditText authorName;
    private Button doneB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_book_info);

        bookName = (EditText) findViewById(R.id.bookName);
        bookAge = (EditText) findViewById(R.id.bookAge);
        authorName = (EditText) findViewById(R.id.bookAuthorId);

        UserController userController = UserController.getInstance();
       // BookModel bModel = new BookModel(bookName.toString(), "dfgdf", "");


        String imageDirectory = ImageStorage.getImageDirectory();
        File imgFile = new File(imageDirectory + "/profile.jpg");

        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Resources res=getResources();
            BitmapDrawable bitmapDrawable=new BitmapDrawable(res, myBitmap);
            RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.layoutR);
            relativeLayout.setBackground(bitmapDrawable);
        }

        doneB = (Button) findViewById(R.id.doneB);

        doneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (bookName.getText().toString().trim().equals("")) {
                    bookName.setError("Required");
                }
                else if (bookAge.getText().toString().trim().equals("")) {
                    bookAge.setError("Required");
                }
                else if (authorName.getText().toString().trim().equals("")) {
                    authorName.setError("Required");
                } else {
                    Intent intent = new Intent(getApplicationContext(), BookRequest.class);
                    startActivity(intent);
                }
            }

        });
    }
}
