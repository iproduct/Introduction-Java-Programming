package tickets.model;

import java.util.BitSet;
import java.util.Date;

public class Event implements Comparable<Event>{
	private static long count = 0;
	private long id = count++;
	private String title;
	private String description;
	private String site;
	private Date start, end;
	private int ticketNumber;
	private double ticketPrice;
	private BitSet placesSold;
	
	
	public Event() {
	}
	
	public Event(String title, String description, String site, Date start, Date end) {
		this.title = title;
		this.description = description;
		this.site = site;
		this.start = start;
		this.end = end;
	}

	public Event(String title, String description, String site, Date start, Date end, int ticketNumber,
			double ticketPrice) {
		this.title = title;
		this.description = description;
		this.site = site;
		this.start = start;
		this.end = end;
		this.ticketNumber = ticketNumber;
		this.ticketPrice = ticketPrice;
	}
	
	public Event(long id, String title, String description, String site, Date start, Date end, int ticketNumber,
			double ticketPrice) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.site = site;
		this.start = start;
		this.end = end;
		this.ticketNumber = ticketNumber;
		this.ticketPrice = ticketPrice;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public BitSet getPlacesSold() {
		if(placesSold == null) 
			placesSold = new BitSet(getTicketNumber());
		return placesSold;
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
		if (!(obj instanceof Event))
			return false;
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=").append(id).append(", title=").append(title).append(", description=")
			.append(description).append(", site=").append(site).append(", start=").append(start).append(", end=")
			.append(end).append(", ticketNumber=").append(ticketNumber).append(", ticketPrice=").append(ticketPrice)
			.append("]");
		return builder.toString();
	}
	
	@Override
	public int compareTo(Event event) {
		return getStart().compareTo(event.getStart());
	}

	public static void main(String[] args) {
		Event event = new Event(
			"OpenFest", "Festival of open source technologies",
			"Phylocharmony", new Date(), new Date(), 1500, 0);
		System.out.println(event);

	}

}
