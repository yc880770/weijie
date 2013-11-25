package com.jdy.weijie.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jdy.weijie.R;
import com.jdy.weijie.model.shopping.Order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * �ҵĶ����б�������
 * @author Administrator
 *
 */
public class OrderAdapter extends BaseAdapter {
	/**
	 * ����б�
	 */
	private List<Order> orders=new ArrayList<Order>();
	/**
	 * layout
	 */
	private int item;
	LayoutInflater layoutInflater;
	public OrderAdapter() {}
	
	public OrderAdapter(Context context, List<Order> orders, int item) {
		this.orders = orders;
		this.item = item;
		this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
	}

	public int getCount() {
		return orders.size();
	}

	public Object getItem(int position) {
		return orders.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView storeName;
		TextView commodityName;
		ImageView commodityImage;
		TextView commodityNum;
		TextView commodityItem1;
		TextView commodityItem2;
		TextView commodityMoney;
		if(convertView==null){
			convertView = layoutInflater.inflate(item, null);
            storeName=(TextView) convertView.findViewById(R.id.order_item_storeNameTextView);
            commodityName=(TextView) convertView.findViewById(R.id.order_item_commodityNameView);
            commodityImage=(ImageView) convertView.findViewById(R.id.order_item_commodityImageView);
            commodityNum=(TextView) convertView.findViewById(R.id.order_item_commodityNumTextView);
            commodityItem1=(TextView) convertView.findViewById(R.id.order_item_commodityItem1TextView);
            commodityItem2=(TextView) convertView.findViewById(R.id.order_item_commodityItem2TextView);
            commodityMoney=(TextView) convertView.findViewById(R.id.order_item_commodityMoneyTextView);
			convertView.setTag(new OrderWrapper(storeName, commodityName, commodityImage,commodityNum, commodityItem1, commodityItem2,commodityMoney ));
		}else{
			OrderWrapper wrapper=(OrderWrapper) convertView.getTag();
            storeName=wrapper.storeName;
            commodityName=wrapper.commodityName;
            commodityImage=wrapper.commodityImage;
            commodityNum=wrapper.commodityNum;
            commodityItem1=wrapper.commodityItem1;
            commodityItem2=wrapper.commodityItem2;
            commodityMoney=wrapper.commodityMoney;
		}
		Order order=orders.get(position);
        storeName.setText(order.getStoreName());
        commodityName.setText(order.getCommodityName());
        commodityImage.setImageDrawable(order.getCommodityImageUrl());
        commodityNum.setText(order.getCommodityNum()+"");
        commodityItem1.setText("+"+order.getCommodityItem1());
        commodityItem2.setText("+"+order.getCommodityItem2());
        commodityMoney.setText("￥ "+order.getMoney()+"");

		return convertView;
	}
	
	private final class OrderWrapper{
		TextView storeName;
		TextView commodityName;
		ImageView commodityImage;
		TextView commodityNum;
		TextView commodityItem1;
		TextView commodityItem2;
		TextView commodityMoney;
		public OrderWrapper(TextView storeName, TextView commodityName, ImageView commodityImage,
				TextView commodityNum, TextView commodityItem1, TextView commodityItem2, TextView commodityMoney) {
			this.storeName = storeName;
			this.commodityName = commodityName;
			this.commodityImage = commodityImage;
			this.commodityNum = commodityNum;
			this.commodityItem1 = commodityItem1;
			this.commodityItem2 = commodityItem2;
			this.commodityMoney = commodityMoney;
		}
	}
}
