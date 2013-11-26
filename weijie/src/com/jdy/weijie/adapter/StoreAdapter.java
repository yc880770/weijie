package com.jdy.weijie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jdy.weijie.R;
import com.jdy.weijie.common.L;
import com.jdy.weijie.model.shopping.Order;
import com.jdy.weijie.model.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * �ҵĶ����б�������
 * @author Administrator
 *
 */
public class StoreAdapter extends BaseAdapter {
	/**
	 * ����б�
	 */
	private List<Store> stores=new ArrayList<Store>();
	/**
	 * layout
	 */
	private int oddItem;
	private int evenItem;
	LayoutInflater layoutInflater;
	public StoreAdapter() {}

	public StoreAdapter(Context context, List<Store> orders, int oddItem,int evenItem) {
		this.stores = orders;
		this.oddItem = oddItem;
		this.evenItem = evenItem;
		this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
	}

	public int getCount() {
		return stores.size();
	}

	public Object getItem(int position) {
		return stores.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView storeName;
		TextView storeType;
		ImageView storeImageUrl;
		TextView storeDistance;
		TextView deliveryTime;
		TextView sendMoney;

		if(convertView==null){

            if (position%2==0|position==0)
            {
                convertView = layoutInflater.inflate(oddItem, null);
                storeName=(TextView) convertView.findViewById(R.id.store_odd_item_storeNameTextView);
                storeType=(TextView) convertView.findViewById(R.id.store_odd_item_storeTypeTextView);
                storeImageUrl=(ImageView) convertView.findViewById(R.id.store_odd_item_storeImageView);
                storeDistance=(TextView) convertView.findViewById(R.id.store_odd_item_storeDistanceTextView);
                deliveryTime=(TextView) convertView.findViewById(R.id.store_odd_item_deliveryTimeTextView);
                sendMoney=(TextView) convertView.findViewById(R.id.store_odd_item_sendMoneyTextView);
                convertView.setTag(new OrderWrapper(storeName, storeType, storeImageUrl,storeDistance,deliveryTime, sendMoney));


//                return convertView;
            }else
            {
                convertView = layoutInflater.inflate(evenItem, null);
                storeName=(TextView) convertView.findViewById(R.id.store_even_item_storeNameTextView);
                storeType=(TextView) convertView.findViewById(R.id.store_even_item_storeTypeTextView);
                storeImageUrl=(ImageView) convertView.findViewById(R.id.store_even_item_storeImageView);
                storeDistance=(TextView) convertView.findViewById(R.id.store_even_item_storeDistanceTextView);
                deliveryTime=(TextView) convertView.findViewById(R.id.store_even_item_deliveryTimeTextView);
                sendMoney=(TextView) convertView.findViewById(R.id.store_even_item_sendMoneyTextView);
                convertView.setTag(new OrderWrapper(storeName, storeType, storeImageUrl,storeDistance,deliveryTime, sendMoney));


//                return convertView;
            }


//           L.d(position+" position");
		}else{
			OrderWrapper wrapper=(OrderWrapper) convertView.getTag();
            storeName=wrapper.storeName;
            storeImageUrl=wrapper.storeImageUrl;
            storeType=wrapper.storeType;
            storeDistance=wrapper.storeDistance;
            deliveryTime=wrapper.deliveryTime;
            sendMoney=wrapper.sendMoney;

		}

        Store store=stores.get(position);
        storeName.setText(store.getStoreName());
        storeType.setText(store.getStoreType());
        storeImageUrl.setImageDrawable(store.getStoreImageUrl());
        storeDistance.setText(store.getStoreDistance()+"M");
        deliveryTime.setText(store.getDeliveryTime()+"h");
        sendMoney.setText(store.getSendMoney()+"元");

//        L.d(position+"con position");

        return convertView;
	}

    private void initDate(int position)
    {

    }
	
	private final class OrderWrapper{
		TextView storeName;
		TextView storeType;
        TextView storeDistance;
		ImageView storeImageUrl;
		TextView deliveryTime;
		TextView sendMoney;
		public OrderWrapper(TextView storeName, TextView storeType, ImageView storeImageUrl, TextView storeDistance,
				TextView deliveryTime, TextView sendMoney) {
			this.storeName = storeName;
			this.storeType = storeType;
			this.storeImageUrl = storeImageUrl;
			this.storeDistance = storeDistance;
			this.deliveryTime = deliveryTime;
			this.sendMoney = sendMoney;
		}
	}
}
