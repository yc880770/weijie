package com.jdy.weijie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jdy.weijie.R;
import com.jdy.weijie.adapter.StoreAdapter;
import com.jdy.weijie.model.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JinDouYun
 * Date: 13-11-26
 * Time: 下午7:02
 * To change this template use File | Settings | File Templates.
 */
public class StoreActivity  extends Activity {
      private PullToRefreshListView storeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.store);

        storeListView = (PullToRefreshListView) findViewById(R.id.store_listView);
        init();

    }

    private void init() {
        List<Store>  list = new ArrayList<Store>();
//
        for (int i=0; i < 5; i++)
        {
            Store order = new Store(i,"肯德基太白南路店",getResources().getDrawable(R.drawable.ic_launcher),"便利店",200,0.4 , 38);
//            L.d(order.toString());
            list.add(order);
        }
        storeListView.setAdapter(new StoreAdapter(this,list,R.layout.store_odd_item,R.layout.store_even_item));

    }
}
