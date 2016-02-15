package tickets;

import tickets.controller.EventController;
import tickets.controller.TicketController;

public class TicketsApp {
	//Design pattern Singleton
	private EventController eventController = 
			new EventController();
	private TicketController ticketController = 
			new TicketController(eventController);

	public EventController getEventController(){
		return eventController;
	}
	
	public TicketController getTicketController(){
		return ticketController;
	}
	
	public TicketsApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
