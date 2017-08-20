package info.androidhive.materialdesign.controllers;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import info.androidhive.materialdesign.model.BookModel;
import info.androidhive.materialdesign.model.UserModel;
import info.androidhive.materialdesign.utilities.JSONUtils;

/**
 * Created by akash on 8/15/17.
 */

public class UserController {
    private List<UserModel> userList;
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
        JSONUtils users = new JSONUtils();
        String jArray = users.parseJSONData(context);

        ObjectMapper mapper = new ObjectMapper();
        userList = new ArrayList<UserModel>();
        try {
            userList = Arrays.asList(mapper.readValue(jArray, UserModel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<UserModel> getUserList() {
        return userList;
    }
}
