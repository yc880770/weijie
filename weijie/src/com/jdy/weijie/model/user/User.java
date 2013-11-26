package com.jdy.weijie.model.user;

import com.jdy.weijie.model.store.Store;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JinDouYun
 * Date: 13-11-25
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userName;
    private int userId;
    private String userPassword;
    private String userReal;
    private String userAddress;
    private double userLongitude;
    private double userLatitude;
    private int userPhone;
    private List<Store> userStoreCollect ;

    public User(){}
    public User(int userId, String userName, String userPassword, String userReal, String userAddress, int userPhone, List<Store> userStoreCollect,double userLatitude, double userLongitude )
    {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userStoreCollect = userStoreCollect;
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserReal() {
        return userReal;
    }

    public void setUserReal(String userReal) {
        this.userReal = userReal;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public List<Store> getUserStoreCollect() {
        return userStoreCollect;
    }

    public void setUserStoreCollect(List<Store> userStoreCollect) {
        this.userStoreCollect = userStoreCollect;
    }
}
