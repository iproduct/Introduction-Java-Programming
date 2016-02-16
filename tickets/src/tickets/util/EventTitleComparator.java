package tickets.util;

import java.util.Comparator;

import tickets.model.Event;

public class EventTitleComparator implements Comparator<Event> {

	@Override
	public int compare(Event e1, Event e2) {
		return e1.getTitle().compareToIgnoreCase(e2.getTitle());
	}

}
