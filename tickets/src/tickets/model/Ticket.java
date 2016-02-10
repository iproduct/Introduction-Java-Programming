package tickets.model;

import java.util.Date;

public class Ticket {
	private static long counter = 0;
	private long id = counter++;
    private Event event;
    private double price;
    private String receiver;
    private int placeNumber;
    
	public Ticket() {
	}

	public Ticket(Event event, int placeNumber) {
		this.event = event;
		this.price = event.getTicketPrice();
		this.placeNumber = placeNumber;
	}

	public Ticket(Event event, double price, String receiver, int placeNumber) {
		this.event = event;
		this.price = price;
		this.receiver = receiver;
		this.placeNumber = placeNumber;
	}
	
	public Ticket(long id, Event event, double price, String receiver, int placeNumber) {
		this.id = id;
		this.event = event;
		this.price = price;
		this.receiver = receiver;
		this.placeNumber = placeNumber;
	}
	
	public static long getCounter() {
		return counter;
	}

	public static void setCounter(long counter) {
		Ticket.counter = counter;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ticket))
			return false;
		Ticket other = (Ticket) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [id=").append(id).append(", event=")
		.append(event).append(", price=").append(price)
		.append(", receiver=").append(receiver)
		.append(", placeNumber=").append(placeNumber).append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		Ticket[] tickets = new Ticket[10];
		Event event = new Event(
			"OpenFest", "Festival of open source technologies",
			"Phylocharmony", new Date(), new Date(), 1500, 0);
		for(int i =0; i < tickets.length; i++){
			tickets[i] = new Ticket(event, 10 + i);
		}
		
		//print sold tickets
		for(Ticket t : tickets){
			System.out.println(t.getId() 
				+ " - Event: " + t.getEvent().getTitle()
				+ ", Place: " + t.getPlaceNumber());
		}
			
	}

}
