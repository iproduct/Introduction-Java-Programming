package tickets.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tickets.model.Event;

public class OutputDialogs {
	private static final SimpleDateFormat sdf = 
		new SimpleDateFormat("dd.MM.yyyy HH:mm");

	public static void showError(String message) {
		System.out.println("Error: " + message);
	}
	
	public static void printEvents(List<Event> events){
//		Collections.sort(events, new EventTitleComparator());

//		Collections.sort(events, new Comparator<Event> () {
//			@Override
//			public int compare(Event e1, Event e2) {
//				return e1.getTicketNumber() - e2.getTicketNumber();
//			}	
//		});
		
		Collections.sort(events, 
			(e1, e2) -> (int)Math.signum(e2.getTicketPrice() - e1.getTicketPrice()));
		
		String header = String.format(
			"|%6s | %20.20s | %16.16s | %16.16s |%4s | %7s |",
			"ID ", "Title         ", "Start     ", "End       ", "Pls", "Price");	
		System.out.println(header);
		for(Event ev : events) {
			String row = String.format(
				"|%6d | %-20.20s | %16.16s | %16.16s |%4d | %7.2f |",
				ev.getId(), ev.getTitle(), 
				sdf.format(ev.getStart()), 
				sdf.format(ev.getEnd()), 
				ev.getTicketNumber(), ev.getTicketPrice());	
			System.out.println(row);
		}
		

	}
	
	public static void main(String[] args) throws ParseException {
		Event[] events = {
			new Event("Expecting Godo", "Famous classical play.", "Army Theater", 
					sdf.parse("30.02.2016 19:00"), 
					sdf.parse("30.02.2016 21:30"), 480, 23.5),
			new Event("MobiCon", "Mobile technologies conference", "Interpred", 
					sdf.parse("27.02.2016 9:30"), 
					sdf.parse("27.02.2016 19:30"), 1100, 35),
			new Event("OpenFest", "Festival of open source technologies", "Phylocharmony", 
					sdf.parse("24.10.2015 09:00"), 
					sdf.parse("25.10.2015 19:00"), 900, 18),
			new Event("New Movie", "Comedy", "NDK", 
					sdf.parse("25.02.2016 18:00"), 
					sdf.parse("25.02.2016 20:30"), 800, 22.5),
		};
		printEvents(Arrays.asList(events));
	}

}
