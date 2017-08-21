package info.androidhive.materialdesign.controllers;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.BookUserMapper;
import info.androidhive.materialdesign.model.BookModel;
import info.androidhive.materialdesign.model.UserModel;
import info.androidhive.materialdesign.utilities.JSONUtils;
import info.androidhive.materialdesign.utilities.MapUtils;

/**
 * Created by akash on 8/15/17.
 */

public class UserController {
    private UserModel user;
    private List<UserModel> userList;
    private List<BookUserMapper> matchBookResults;
    private BookModel bookReq;
    private BookModel bookLend;
    private static UserController instance = null;


    private UserController(){

    }

    public static UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }

    public void initialize(Context context){
        JSONUtils jUtil = new JSONUtils();
        String jStringUser = jUtil.parseJSONData(context, R.raw.self);
        String jStringUsers = jUtil.parseJSONData(context, R.raw.users);
        ObjectMapper mapper = new ObjectMapper();
        userList = new ArrayList<UserModel>();
        try {
            user = mapper.readValue(jStringUser,UserModel.class);
            userList = Arrays.asList(mapper.readValue(jStringUsers, UserModel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void matchMake(){
        matchBookResults = new ArrayList<>();
        double distInKm = 0.0;
        for(UserModel uModel : userList){
            bookReq = null;
            bookLend = null;
            boolean foundMatch = bookSearching(user.getbookRequest(),uModel.getBookOwned(),true) && bookSearching(uModel.getbookRequest(),user.getBookOwned(),false);
            if(foundMatch){
                distInKm = MapUtils.distance(user.getLatitude(),user.getLongitude(),uModel.getLatitude(),uModel.getLongitude());
                double roundOffDistance = (double) Math.round(distInKm * 100) / 100;
                matchBookResults.add(new BookUserMapper(uModel,bookReq,bookLend,roundOffDistance));
            }
        }
        Collections.sort(matchBookResults);
    }


    public boolean bookSearching(List<BookModel> request,List<BookModel> owner,boolean self){
        for(BookModel bRequest : request){
            for(BookModel bOwner : owner){
                if(bRequest.equals(bOwner)){
                    if(self){
                        bookReq = bOwner;
                    } else{
                        bookLend = bOwner;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public List<BookUserMapper> getMatchBookResults() {
        return matchBookResults;
    }
}
