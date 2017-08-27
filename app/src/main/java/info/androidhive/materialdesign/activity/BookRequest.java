package info.androidhive.materialdesign.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import info.androidhive.materialdesign.R;

public class BookRequest extends AppCompatActivity {

    private EditText bookName;
    private EditText authorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request);

        bookName=(EditText)findViewById(R.id.bookName);
        authorName=(EditText)findViewById(R.id.bookAuthor);

        if(bookName.getText().toString().trim().equals("")){
            bookName.setError("book name is required");
        }
    }
}
