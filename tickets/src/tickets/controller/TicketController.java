package tickets.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tickets.exception.EntityAlreadyExistsException;
import tickets.exception.EntityDoesNotExistException;
import tickets.model.Event;
import tickets.model.Ticket;

public class TicketController {
	private List<Ticket> tickets = new ArrayList<>();
	
	public Event addEvent(Event event) 
			throws EntityAlreadyExistsException {
		if(events.contains(event))
			throw new EntityAlreadyExistsException(
					"Event already added with ID: " + event.getId());
		events.add(event);
		return event;
	}
	
	public List<Event> getEvents(){
		return events;
	}
	
	public Event editEvent(Event event) throws EntityDoesNotExistException {
		int index = events.indexOf(event);
		if(index < 0)
			throw new EntityDoesNotExistException(
				"Event with ID: " + event.getId() + "does not exist.");
		
		events.set(index, event);
		return event;
	}
	
	public Event deleteEventById(long eventId) 
			throws EntityDoesNotExistException {
		Event testEvent = new Event();
		testEvent.setId(eventId);
		int index = events.indexOf(testEvent);
		if(index < 0)
			throw new EntityDoesNotExistException(
				"Event with ID: " + eventId + "does not exist.");
		
		return events.remove(index);
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
			
			//edit event
			event.setTitle("OpenFest 2016");
			event.setTicketNumber(2000);
			controller.editEvent(event);
			
			System.out.println("\nAfter edit:");
			for(Event e : controller.getEvents())
				System.out.println(e);
			
		} catch (EntityAlreadyExistsException e) {
			e.printStackTrace();
		} catch (EntityDoesNotExistException e1) {
			e1.printStackTrace();
		}
		
	}

}
