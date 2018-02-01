package library.control;

import java.util.Arrays;

import library.model.Book;
import library.model.Genre;

public class Library {
	public static final int MAX_BOOKS = 1000;
	
	private Book[] books = new Book[1000];
	private int numBooks = 0;
	
	public boolean addBook(Book book) {
		books[numBooks++] = book;
		return true;
	}
	
	public Book[] getAllBooks() {
		return Arrays.copyOf(books, numBooks);	
	}
	
	public static String formatAsTable(Book[] books) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("|%3s|%30s|%16s|%4s|%10s|%10s|\n", 
				"Id ", "Title              ", "Author      ", "Year", "Publisher ", "Genre  "));
		char[] underline = new char[80];
		Arrays.fill(underline, '-');
		sb.append(new String(underline) + "\n");
		
		for(Book book : books) {
			sb.append(String.format("|%3s|%-30s|%-16s|%4d|%-10s|%-10s|\n", 
					book.getId(), book.getTitle(), book.getAuthors(),
					book.getYear(), book.getPublisher(), book.getGenre()));
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Library library = new Library(); // Default constructor
		
		Book b1 = new Book("Thinking in Java 4ed.", "Bruce Eckel", 2006);
		library.addBook(b1);
		
		Book b2 = new Book("Algorithms + Data Structures = Programs", "Niklaus Wirth", 1976, 
				"ISBN 978-0-13-022418-7", "Prentice-Hall", Genre.SOFTWARE, 
				new String[] {"programming", "algorithm", "data structure", "classic"});
		library.addBook(b2);
		
//		for(Book book : library.getAllBooks()) {
//			System.out.println(book);
//		}
		
		System.out.println(formatAsTable(library.getAllBooks()));
		
		
	}

}
