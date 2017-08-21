package info.androidhive.materialdesign.model;

import android.support.annotation.NonNull;

/**
 * Created by akash on 8/19/17.
 */

public class BookUserMapper implements Comparable {
    private UserModel user;
    private BookModel bookBorrow;
    private BookModel bookLend;
    private double distance;


    public BookUserMapper(UserModel user, BookModel bookBorrow, double distance) {
        this.user = user;
        this.bookBorrow = bookBorrow;
        this.distance = distance;
    }

    public BookUserMapper(UserModel user, BookModel bookBorrow, BookModel bookLend, double distance) {
        this.user = user;
        this.bookBorrow = bookBorrow;
        this.bookLend = bookLend;
        this.distance = distance;
    }

    public UserModel getUser() {
        return user;
    }

    public BookModel getBookBorrow() {
        return bookBorrow;
    }

    public double getDistance() {
        return distance;
    }

    public BookModel getBookLend() {
        return bookLend;
    }

    @Override
    public int compareTo(@NonNull Object another) {
        BookUserMapper bModel = (BookUserMapper) another;
        return (this.distance < bModel.distance ) ? -1: (this.distance > bModel.distance) ? 1:0 ;
    }
}
