package com.jdy.weijie.model.shopping;

import java.util.List;

/**
 * 购物车查询
 * 
 * @author yc
 * 
 */
public class OrderQuery {
	private List<Order> orders;
	/**
	 * ������
	 */
	private Integer totalRecords;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

}
