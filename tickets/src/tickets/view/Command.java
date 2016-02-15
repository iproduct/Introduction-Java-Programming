package tickets.view;

public interface Command {
	String getTitle();
	boolean executeAction();
}
