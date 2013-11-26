package com.jdy.weijie.model.store;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: JinDouYun
 * Date: 13-11-26
 * Time: 上午11:45
 * To change this template use File | Settings | File Templates.
 */
public class Store {

    private String storeName;
    private Drawable storeImageUrl;
    private int storeId;
    private String storeType;
    private int storeDistance;
    private double deliveryTime;
    private int sendMoney;

    public  Store(){}

    public  Store(int storeId, String storeName, Drawable storeImageUrl, String storeType, int storeDistance, double deliveryTime, int sendMoney)
    {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeImageUrl = storeImageUrl;
        this.storeType = storeType;
        this.storeDistance = storeDistance;
        this.deliveryTime = deliveryTime;
        this.sendMoney = sendMoney;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public int getStoreDistance() {
        return storeDistance;
    }

    public void setStoreDistance(int storeDistance) {
        this.storeDistance = storeDistance;
    }

    public double getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(double deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(int sendMoney) {
        this.sendMoney = sendMoney;
    }

    public Drawable getStoreImageUrl() {
        return storeImageUrl;
    }

    public void setStoreImageUrl(Drawable storeImageUrl) {
        this.storeImageUrl = storeImageUrl;
    }

    @Override
    public String toString() {
        return "id:"+this.storeId+" name:"+this.storeName
                +" storeImageUrl"+this.storeImageUrl
                +" storeType"+this.storeType+" storeDistance"+this.storeDistance
                +" deliveryTime"+this.deliveryTime+" sendMoney"+this.sendMoney;
    }
}
