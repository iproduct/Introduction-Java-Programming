package tickets.model;

import java.util.Arrays;

public class GroupTicket extends Ticket{
	public static final int GROUP_TICKET_PLACEHOLDER = -1;
	private int[] places;
	
	public GroupTicket() {
	}

	public GroupTicket(Event event, double price, String receiver, int[] places) {
		super(event, price, receiver, GROUP_TICKET_PLACEHOLDER);
		this.places = places;
	}

	public GroupTicket(Event event, int[] places) {
		super(event, GROUP_TICKET_PLACEHOLDER);
		this.places = places;
	}

	public GroupTicket(long id, Event event, double price, String receiver, int[] places) {
		super(id, event, price, receiver, GROUP_TICKET_PLACEHOLDER);
		this.places = places;
	}

	public GroupTicket(Event event, int place, int... morePlaces) {
		super(event, GROUP_TICKET_PLACEHOLDER);
		int[] places = new int[morePlaces.length + 1];
		places[0] = place;
		for(int i = 0; i < morePlaces.length; i++){
			places[i+1] = morePlaces[i];
		}
		this.places = places;
	}

	public int[] getPlaces() {
		return places;
	}

	public void setPlaces(int[] places) {
		this.places = places;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GroupTicket [getPlaces()=")
			.append(Arrays.toString(getPlaces())).append(", getEvent()=")
			.append(getEvent()).append(", getPrice()=")
			.append(getPrice()).append(", getReceiver()=")
			.append(getReceiver()).append(", getPlaceNumber()=")
			.append(getPlaceNumber()).append(", getId()=")
			.append(getId()).append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
