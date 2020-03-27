package com.shyam.app.order.bo;

import com.shyam.app.model.order.Order;
import com.shyam.app.order.bo.exception.BOException;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
