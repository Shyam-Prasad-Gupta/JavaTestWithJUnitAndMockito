package com.shyam.app.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.shyam.app.spring.ticket.service.TicketServiceImpl;

class TicketServiceTest {

	private static final int RESULT = 1;
	private static final String MOBILE_NO = "8468887997";
	private static final String PASSENGER_NAME = "Shyam";

	@Test
	void test() {
		TicketServiceImpl ticketService = new TicketServiceImpl();
		
		int result = ticketService.buyTicket(PASSENGER_NAME, MOBILE_NO);
		Assertions.assertEquals(result,	RESULT);
	}

}
