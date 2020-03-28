package com.shyam.app.spring.ticket.dao;

import org.springframework.stereotype.Component;

import com.shyam.app.spring.ticket.model.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
