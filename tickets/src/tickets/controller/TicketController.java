package tickets.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

import tickets.exception.EntityAlreadyExistsException;
import tickets.exception.EntityDoesNotExistException;
import tickets.exception.TicketNotValidException;
import tickets.model.Event;
import tickets.model.GroupTicket;
import tickets.model.Ticket;

public class TicketController {
	private List<Ticket> tickets = new ArrayList<>();
	private EventController eventController;
	
	public TicketController(EventController evController){
		eventController = evController;
	}
	
	public Ticket sellTicket(Ticket ticket) 
			throws EntityAlreadyExistsException,  TicketNotValidException{
		if (tickets.contains(ticket))
			throw new EntityAlreadyExistsException("Ticket already added with ID: " + ticket.getId());
		Event event = ticket.getEvent();
		if(event == null)
			throw new TicketNotValidException(
				"Event not specified in ticket ID: "+ ticket.getId());
		event = eventController.getEventById(event.getId());
		
		BitSet placesSold = event.getPlacesSold();
		//validate ticket place is valid and places not already sold 
		for(int place:  ticket.getPlaces()) {
			if(place > event.getTicketNumber() || placesSold.get(place -1))
				throw new TicketNotValidException(
					"Ticket place number not valid: " + place 
					+ ". Should be in [1 to " + event.getTicketNumber() + "]");
		}
		
		//sell ticket places
		for(int place: ticket.getPlaces()){
			placesSold.set(place - 1);
		}
		tickets.add(ticket);
		return ticket;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public Ticket editTicket(Ticket ticket) throws EntityDoesNotExistException {
		int index = tickets.indexOf(ticket);
		if (index < 0)
			throw new EntityDoesNotExistException("Ticket with ID: " + ticket.getId() + "does not exist.");

		tickets.set(index, ticket);
		return ticket;
	}

	public Ticket deleteTicketById(long ticketId) throws EntityDoesNotExistException {
		Ticket testTicket = new Ticket();
		testTicket.setId(ticketId);
		int index = tickets.indexOf(testTicket);
		if (index < 0)
			throw new EntityDoesNotExistException("Ticket with ID: " + ticketId + "does not exist.");

		return tickets.remove(index);
	}

	public static void main(String[] args){
		Event[] events = {
			new Event("OpenFest", "Festival of open source technologies", 
					"Phylocharmony", new Date(), new Date(), 1500, 0),
			new Event("New Movie", "Comedy", "NDK", new Date(), new Date(), 800, 10),
			new Event("Expecting Godo", "Famous classical play.", 
					"Army Theater", new Date(), new Date(), 150, 12)
		};
		
		Ticket[] testTickets = {
				new GroupTicket(events[0], 2, 7, 9, 14, 15),
				new Ticket(events[2], events[2].getTicketPrice(), "Ivan Petrov", 15),
				new Ticket(events[0], 45),
				new GroupTicket(events[0], 10, 11, 12, 13),
				new GroupTicket(events[2], 21, 22, 23, 24, 25),
				new Ticket(events[0], 8)
			};
		
		//create controllers
		EventController eventController = new EventController();
		TicketController ticketController = new TicketController(eventController);
		
		//add sample events
		for(Event ev : events){
			try {
				eventController.addEvent(ev);
			} catch (EntityAlreadyExistsException e) {
				e.printStackTrace();
			}
		}
		
		//sell test tickets
		for(Ticket ticket : testTickets){
			try {
				ticketController.sellTicket(ticket);
			} catch (EntityAlreadyExistsException e) {
				e.printStackTrace();
			} catch (TicketNotValidException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//print sold tickets
		for(Ticket t : ticketController.getTickets()){
			System.out.println(t.getId() 
				+ " - Event: " + t.getEvent().getTitle()
				+ ", Place: " + Arrays.toString(t.getPlaces()));
		}
		

	}

}
