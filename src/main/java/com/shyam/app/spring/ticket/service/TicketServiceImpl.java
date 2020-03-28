package com.shyam.app.spring.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shyam.app.spring.ticket.dao.TicketDAO;
import com.shyam.app.spring.ticket.model.Ticket;

@Component
public class TicketServiceImpl {

	@Autowired
	TicketDAO dao;

	public int buyTicket(String passengerName, String mobileNo) {
		// write the logic to save create the ticket save the ticket and return a ticket
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setMobileNo(mobileNo);

		// save the ticket
		int ticketId = dao.createTicket(ticket);

		return 1;
	}

}
