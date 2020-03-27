package com.shyam.app.order.bo;

import java.nio.BufferOverflowException;
import java.sql.SQLException;

import com.shyam.app.model.order.Order;
import com.shyam.app.order.bo.exception.BOException;
import com.shyam.app.order.dao.OrderDAO;

public class OrderBOImpl implements OrderBO {

	private OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {

		try {
			Order item = dao.create(order);
			if (item != null && item.getId() != 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return false;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order item = dao.read(id);
			if (item != null && item.getId() != 0) {
				item.setStatus("cancelled");
				int id1 = dao.update(item);
				if (id1 != 0)
					return true;
				else
					return false;
			} else
				throw new SQLException();
		} catch (SQLException e) {
			throw new BOException(e);
		}
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {

		try {
			int id1 = dao.delete(id);
			if (id1 != 0)
				return true;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return false;
	}

	public OrderDAO getDAO() {
		return dao;
	}

	public void setDAO(OrderDAO dao) {
		this.dao = dao;
	}

}
