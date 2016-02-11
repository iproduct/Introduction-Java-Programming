package tickets.controller;

import tickets.exception.EntityAlreadyExistsException;
import tickets.model.Event;
import tickets.model.Ticket;

public class TicketController {
	private Event[] events = {};
	private Ticket[] tickets = {};
	
	public void addEvent(Event event) 
			throws EntityAlreadyExistsException {
		// validate event is new one
		for(Event e : events){
			if(e.equals(event)){
				throw new EntityAlreadyExistsException(
					"Event already added with ID: " + event.getId());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
