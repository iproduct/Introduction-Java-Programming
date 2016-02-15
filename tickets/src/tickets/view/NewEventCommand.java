package tickets.view;

import tickets.TicketsApp;
import tickets.exception.EntityAlreadyExistsException;
import tickets.model.Event;

public class NewEventCommand implements Command {
	private InputDialogs input;
	private OutputDialogs output;
	private TicketsApp application;
	
	public NewEventCommand(InputDialogs input, 
			OutputDialogs output, TicketsApp mainApp){
		this.input = input;
		this.output = output;
	}

	@Override
	public String getTitle() {
		return "Add new event";
	}

	@Override
	public boolean executeAction() {
		Event event = input.inputEvent();
		if(event == null) //cancel
			return false;
		try {
			application.getEventController().addEvent(event);
			return true;
		} catch (EntityAlreadyExistsException e) {
			output.showError(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
