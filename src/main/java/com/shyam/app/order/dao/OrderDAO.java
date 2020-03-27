package com.shyam.app.order.dao;

import java.sql.SQLException;

import com.shyam.app.model.order.Order;

public interface OrderDAO {

	public Order create(Order order) throws SQLException;
	public Order read(int id) throws SQLException;
	public int update(Order entity) throws SQLException;
	public int delete(int id) throws SQLException;
}
