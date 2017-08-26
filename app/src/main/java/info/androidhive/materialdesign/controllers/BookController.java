package info.androidhive.materialdesign.controllers;

import java.util.List;

import info.androidhive.materialdesign.model.BookInfoModel;

/**
 * Created by akash on 8/26/17.
 */

public class BookController {
    private List<BookInfoModel> suggestedMatches;
    private static BookController instance = null;

    private BookController(){
    }

    public static BookController getInstance(){
        if(instance == null){
            instance = new BookController();
        }
        return instance;
    }
}
