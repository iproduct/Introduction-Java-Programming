package tickets.controller;

import java.util.Arrays;
import java.util.Date;

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
		Event[] result = new Event[events.length + 1];
		for(int i = 0; i < events.length; i++){
			result[i] = events[i];
		}
		result[result.length - 1] = event;
		events = result;
	}
	
	public Event[] getEvents(){
		return events;
	}

	public static void main(String[] args) {
		TicketController controller = new TicketController();
		Event event = new Event(
				"OpenFest", "Festival of open source technologies",
				"Phylocharmony", new Date(), new Date(), 1500, 0);
		Event event2 = new Event(
				"New Movie", "Comedy",
				"NDK", new Date(), new Date(), 800, 10);
		try {
			controller.addEvent(event);
			controller.addEvent(event2);
			for(Event e : controller.getEvents())
				System.out.println(e);
		} catch (EntityAlreadyExistsException e) {
			e.printStackTrace();
		}
		
	}

}
