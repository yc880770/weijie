package com.jdy.weijie.model.shopping;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.format.Time;

import java.util.Date;

/**
 * Created by JinDouYun on 13-11-25.
 * 购物车模型
 */
public class Order {
    public  static final  int  ORDER_STATUS_SUBMIT=1;
    public  static final  int  ORDER_STATUS_CANCEL=-1;
    public  static final  int  ORDER_STATUS_DEFAULT=0;
    private String commodityName;
    private String storeName;
    private int commodityNum;
    private Drawable commodityImageUrl;
    private String commodityItem1;
    private String commodityItem2;
    private String commodityRemark;
    private float money;
    private Date createTime;
    private int orderStatus;


    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }



    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(int commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getCommodityItem1() {
        return commodityItem1;
    }

    public void setCommodityItem1(String commodityItem1) {
        this.commodityItem1 = commodityItem1;
    }

    public String getCommodityItem2() {
        return commodityItem2;
    }

    public void setCommodityItem2(String commodityItem2) {
        this.commodityItem2 = commodityItem2;
    }

    public String getCommodityRemark() {
        return commodityRemark;
    }

    public void setCommodityRemark(String commodityRemark) {
        this.commodityRemark = commodityRemark;
    }

    public Drawable getCommodityImageUrl() {
        return commodityImageUrl;
    }

    public void setCommodityImageUrl(Drawable commodityImageUrl) {
        this.commodityImageUrl = commodityImageUrl;
    }
}
