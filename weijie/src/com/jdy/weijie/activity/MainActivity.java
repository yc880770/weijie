package com.jdy.weijie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jdy.weijie.R;
import com.jdy.weijie.adapter.OrderAdapter;
import com.jdy.weijie.adapter.StoreAdapter;
import com.jdy.weijie.common.L;
import com.jdy.weijie.model.location.Location;
import com.jdy.weijie.model.location.LocationManager;
import com.jdy.weijie.model.shopping.Order;
import com.jdy.weijie.model.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yc on 13-11-25.
 * 首页Activity
 *
 */
public class MainActivity extends Activity{
    private String TAG = "tabHost";
    private TabHost tabHost;
    private PullToRefreshListView shoppingListView;

//    主页
    private static final String INDEX = "index";
//    店铺收藏
    private static final String COLLECT = "collect";
//    我的资料（云）
    private static final String CLOUD = "cloud";
//    购物车
    private static final String SHOPPING = "shopping";



//    送餐
    private static final String RESTAURANT = "restaurant";
    private View  restaurantButton;

//    便利店
    private static final String STORE = "store";
    private View  storeButton;

//    家政
    private static final String HOMEMAKING = "homemaking";
    private View  homemakingButton;
//
//    private static final String SHOPPING = "shopping";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabHost = (TabHost) findViewById(R.id.tabs);
        shoppingListView = (PullToRefreshListView) findViewById(R.id.main_shopping_listView);
//        restaurantButton =  findViewById(R.id.main_restaurant_button);
//        storeButton = findViewById(R.id.main_dimeStore_button);
//        homemakingButton =  findViewById(R.id.main_homemaking_button);
//        shoppingListView.setPullToRefreshOverScrollEnabled(true);
        tabHost.setup();
        tabHost.setOnTabChangedListener(onTabChangeListener);
        init();




    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this,StoreActivity.class);
        startActivity(intent);
    }

    private void init() {
        View indexRadio  = LayoutInflater.from(this).inflate(R.layout.radio_index,null);
        View collectRadio  = LayoutInflater.from(this).inflate(R.layout.radio_collect, null);
        View cloudRadio  = LayoutInflater.from(this).inflate(R.layout.radio_cloud, null);
        View shoppingRadio  = LayoutInflater.from(this).inflate(R.layout.radio_shopping, null);

        tabHost.addTab(tabHost.newTabSpec(INDEX).setIndicator(indexRadio).setContent(R.id.tab_index));
        tabHost.addTab(tabHost.newTabSpec(SHOPPING).setIndicator(shoppingRadio).setContent(R.id.tab_shopping));
        tabHost.addTab(tabHost.newTabSpec(COLLECT).setIndicator(collectRadio).setContent(R.id.tab_collect));
        tabHost.addTab(tabHost.newTabSpec(CLOUD).setIndicator(cloudRadio).setContent(R.id.tab_cloud));


        locationMe();

    }

    private void locationMe() {
        LocationManager locationManager = new LocationManager(this);
        locationManager.requestLocation(new LocationManager.LocationManagerListener() {
            @Override
            public void onReceiveLocation(Location location) {
                Log.d("location",location.getAddress()+"");
                Log.d("location",location.getCity()+"");
                Log.d("location",location.getLatitude()+" "+location.getLongitude());
                if (location.getAddress()!=""||location.getAddress()!=null)
                {
                    Toast.makeText(MainActivity.this,location.getAddress(),Toast.LENGTH_SHORT).show();
                }
            }


        });
        locationManager.getLastLocation();
//        Toast.makeText(MainActivity.this,locationManager.getLastLocation().getAddress(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"定位失败。。",Toast.LENGTH_SHORT).show();

    }

    /**
     * TabHost点击监听
     */
   private  TabHost.OnTabChangeListener onTabChangeListener  = new TabHost.OnTabChangeListener()
    {

        @Override
        public void onTabChanged(String s) {
            if (s.endsWith(INDEX))
            {
                displayIndex();
            }
            if (s.endsWith(COLLECT))
            {
                displayCollect();
            }
            if (s.endsWith(CLOUD))
            {
                displayCloud();
            }
            if (s.endsWith(SHOPPING))
            {
                displayShopping();
            }
        }


    };

    private void displayShopping() {
        List<Order>  list = new ArrayList<Order>();

        for (int i=0; i < 6; i++)
        {
            Order order = new Order();
            order.setStoreName("肯德基太白南路店");
            order.setCommodityName("饭堡双人餐");
            order.setCommodityNum(1);
            order.setCommodityItem1("香辣鸡腿堡1个");
            order.setCommodityItem2("黄金咖喱猪扒饭1份");
            order.setMoney(68.5f);
            order.setCommodityImageUrl(getResources().getDrawable(R.drawable.ic_launcher));
            list.add(order);
        }
        shoppingListView.setAdapter(new OrderAdapter(this,list,R.layout.order_item));
//         List<Store>  list = new ArrayList<Store>();
//
//        for (int i=0; i < 5; i++)
//        {
//            Store order = new Store(i,"肯德基太白南路店",getResources().getDrawable(R.drawable.ic_launcher),"便利店",200,0.4 , 38);
////            L.d(order.toString());
//            list.add(order);
//        }

//        shoppingListView.setAdapter(new StoreAdapter(this,list,R.layout.store_odd_item,R.layout.store_even_item));

    }

    private void displayCloud() {
    }

    private void displayCollect() {
            
    }

    private void displayIndex() {


    }
}
