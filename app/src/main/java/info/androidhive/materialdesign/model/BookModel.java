package info.androidhive.materialdesign.model;

import java.util.Objects;

import static android.R.attr.name;

/**
 * Created by Akash_Aman on 14-08-2017.
 */

public class BookModel {
    private String title;
    private String isbn;
    private String imageTag;

    public BookModel() {
    }

    public BookModel(String title, String isbn, String imageTag) {
        this.title = title;
        this.isbn = isbn;
        this.imageTag = imageTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof BookModel)) {
            return false;
        }
        BookModel bookModel = (BookModel) o;
        return Objects.equals(isbn, bookModel.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
