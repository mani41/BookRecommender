package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import info.androidhive.materialdesign.R;

public class BookRequest extends AppCompatActivity {

    private EditText bookName;
    private EditText authorName;
    private Button doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request);

        bookName=(EditText)findViewById(R.id.bookName);
        authorName=(EditText)findViewById(R.id.bookAuthor);
        doneButton=(Button)findViewById(R.id.doneB);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(bookName.getText().toString().trim().equals("")){
                    bookName.setError("book name is required");
                }
                else {
                    Intent intent = new Intent(BookRequest.this, MainActivity.class);
                    startActivity(intent);
                }
            }

        });

    }
}
