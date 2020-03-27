package com.shyam.app.order.bo.test;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.any;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shyam.app.model.order.Order;
import com.shyam.app.order.bo.OrderBOImpl;
import com.shyam.app.order.bo.exception.BOException;
import com.shyam.app.order.dao.OrderDAO;

class OrderBOImplTest {

	@Mock
	private OrderDAO dao;

	private OrderBOImpl bo;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDAO(dao);
	}

	@Test
	public void placeOrder_Should_Create_Order() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Order(1));

		boolean result = bo.placeOrder(order);
		Assertions.assertTrue(result);

		verify(dao).create(order);
	}

	@Test
	public void placeOrder_Should_Not_Create_Order() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(order)).thenReturn(new Order(0));

		boolean result = bo.placeOrder(order);
		Assertions.assertFalse(result);

		verify(dao).create(order);
	}

	@Test
	public void placeOrder_Should_Thorow_BOException() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);

		Assertions.assertThrows(BOException.class, () -> {
			bo.placeOrder(order);
		});
	}

	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order(2);
		when(dao.read(anyInt())).thenReturn(order);
		when(dao.update(order)).thenReturn(2);

		boolean result = bo.cancelOrder(1);
		Assertions.assertTrue(result);

		verify(dao).read(1);
		verify(dao).update(order);
	}

	@Test
	public void cancelOrder_Should_NOT_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order(2);
		when(dao.read(1)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelOrder(1);
		Assertions.assertFalse(result);

		verify(dao).read(1);
		verify(dao).update(order);
	}

	@Test
	public void cancelOrder_Should_Throw_BOException_On_Read() throws SQLException, BOException {

		when(dao.read(1)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			bo.cancelOrder(1);
		});

		verify(dao).read(1);
	}

	@Test
	public void cancelOrder_Should_Throw_BOException_On_Update() throws SQLException, BOException {

		Order order = new Order(2);
		when(dao.read(1)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			bo.cancelOrder(1);
		});

		verify(dao).read(1);
		verify(dao).update(order);
	}

	@Test
	public void deleteOrder_Should_Delete_The_Order() throws SQLException, BOException {

		when(dao.delete(1)).thenReturn(1);
		boolean result = bo.deleteOrder(1);
		Assertions.assertTrue(result);

		verify(dao, atMostOnce()).delete(1);
	}

	@Test
	public void deleteOrder_Should_Not_Delete_The_Order() throws SQLException, BOException {

		when(dao.delete(1)).thenReturn(0);
		boolean result = bo.deleteOrder(1);
		Assertions.assertFalse(result);

		verify(dao).delete(1);
	}

	@Test
	public void deleteOrder_Should_Throw_SQLException_On_Delete() throws SQLException, BOException {

		when(dao.delete(1)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			bo.deleteOrder(1);
		});

		verify(dao).delete(1);
	}

}
