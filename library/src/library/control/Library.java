package library.control;

import java.util.Arrays;
import java.util.Scanner;

import library.model.Book;
import library.model.Genre;

public class Library {
	public static final int MAX_BOOKS = 1000;

	private Book[] books = new Book[1000];
	private int numBooks = 0;
	private Scanner sc = new Scanner(System.in);

	public boolean addBook(Book book) {
		books[numBooks++] = book;
		return true;
	}

	public Book[] getAllBooks() {
		return Arrays.copyOf(books, numBooks);
	}

	public void inputNewBook() {
		Book book = new Book();
		System.out.print("Title: ");
		book.setTitle(sc.nextLine());
		System.out.print("Authors: ");
		book.setAuthors(sc.nextLine());
		
		System.out.print("Year: ");
		String inputStr;
		int year = -1;
		do {
			inputStr = sc.nextLine();
			try {
				year = Integer.parseInt(inputStr);
			} catch(NumberFormatException e) {
				System.out.println("Invalid number. Try again.");
			}
			if(year < 1800) {
				System.out.println("Invalid year (should be after 1900). Try again.");
			}
		} while (year < 1800);
		book.setYear(year);
		
		System.out.print("Publisher: ");
		book.setAuthors(sc.nextLine());

		System.out.print("Genre (");
		for(Genre genre: Genre.values())
			System.out.print(genre.ordinal() + "-" + genre + ", ");
		System.out.print("):");
		
		int genre = -1;
		do {
			inputStr = sc.nextLine();
			try {
				genre = Integer.parseInt(inputStr);
			} catch(NumberFormatException e) {
				System.out.println("Invalid number. Try again.");
			}
			if(genre >= Genre.values().length) {
				System.out.println("No such Genre. Try again.");
			}
		} while(genre < 0 || genre >= Genre.values().length);
		book.setGenre(Genre.values()[genre]);
		
		addBook(book);
	}

	public static String formatAsTable(Book[] books) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("|%3s|%30s|%16s|%4s|%10s|%10s|\n", "Id ", "Title              ", "Author      ", "Year",
				"Publisher ", "Genre  "));
		char[] underline = new char[80];
		Arrays.fill(underline, '-');
		sb.append(new String(underline) + "\n");

		for (Book book : books) {
			sb.append(String.format("|%3s|%-30.30s|%-16.16s|%4d|%-10.10s|%-10.10s|\n", book.getId(), book.getTitle(),
					book.getAuthors(), book.getYear(), book.getPublisher(), book.getGenre()));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Library library = new Library(); // Default constructor

		Book b1 = new Book("Thinking in Java 4ed.", "Bruce Eckel", 2006);
		library.addBook(b1);

		Book b2 = new Book("Algorithms + Data Structures = Programs", "Niklaus Wirth", 1976, "ISBN 978-0-13-022418-7",
				"Prentice-Hall", Genre.SOFTWARE,
				new String[] { "programming", "algorithm", "data structure", "classic" });
		library.addBook(b2);

		// for(Book book : library.getAllBooks()) {
		// System.out.println(book);
		// }

		library.inputNewBook();

		System.out.println(formatAsTable(library.getAllBooks()));

	}

}
