package info.androidhive.materialdesign.model;

import java.util.List;

/**
 * Created by Akash_Aman on 14-08-2017.
 */

public class UserModel {
    private String  userName;
    private String  phoneNumber;
    private double  latitude;
    private double  longitude;
    private String  deviceId;
    private List<BookModel> bookOwned;
    private List<BookModel> bookRequest;

    public UserModel() {
    }

    public UserModel(String userName, String phoneNumber, double latitude, double longitude, String deviceId) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.deviceId = deviceId;
    }

    public UserModel(String userName, String phoneNumber, double latitude, double longitude, String deviceId, List<BookModel> bookOwned, List<BookModel> bookRequest) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.deviceId = deviceId;
        this.bookOwned = bookOwned;
        this.bookRequest = bookRequest;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<BookModel> getBookOwned() {
        return bookOwned;
    }

    public void setBookOwned(List<BookModel> bookOwned) {
        this.bookOwned = bookOwned;
    }

    public List<BookModel> getbookRequest() {
        return bookRequest;
    }

    public void setbookRequest(List<BookModel> bookRequest) {
        this.bookRequest = bookRequest;
    }
}
