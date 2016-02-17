package tickets.util;

import java.util.Comparator;

import tickets.model.Ticket;

public class TicketEventDatePlacesComparator  implements Comparator<Ticket>{

	@Override
	public int compare(Ticket t1, Ticket t2) {
		int result = t1.getEvent().getStart().compareTo(t2.getEvent().getStart());
		if(result == 0)
			result = t2.getPlaces().length - t1.getPlaces().length;
		return result;
	}

}
