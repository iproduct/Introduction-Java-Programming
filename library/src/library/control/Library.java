package library.control;

import java.util.Arrays;
import java.util.Scanner;

import library.model.Author;
import library.model.Book;
import library.model.Genre;

public class Library {
	public static final int MAX_ENTITIES = 1000;

	private Book[] books = new Book[MAX_ENTITIES];
	private int numBooks = 0;
	
	private Author[] authors = new Author[MAX_ENTITIES];
	private int numAuthors = 0;
	
	private Scanner sc = new Scanner(System.in);

	public boolean addBook(Book book) {
		books[numBooks++] = book;
		return true;
	}

	public Book[] getAllBooks() {
		return Arrays.copyOf(books, numBooks);
	}

	public boolean addAuthor(Author author) {
		authors[numAuthors++] = author;
		return true;
	}

	public Author[] getAllAuthors() {
		return Arrays.copyOf(authors, numAuthors);
	}

	public void inputNewBook() {
		Book book = new Book();
		System.out.print("Title: ");
		book.setTitle(sc.nextLine());
		System.out.print("Authors: ");
		String authorStr = sc.nextLine();
		String[] names = authorStr.trim().split(" ");
		Author author = addAndGetAuthor(new Author(names[0], names[names.length - 1]));
		book.setAuthors(new Author[] {author});
		
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
		book.setPublisher(sc.nextLine());

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

	public Author findAuthorByNames(String fName, String lName ) {
		for(int i = 0; i < numAuthors; i++) {
			if(authors[i].getFirstName().equals(fName) 
			&& authors[i].getLastName().equals(lName)) {
				return authors[i];
			}
		}
		return null;
	}
	
	public Author addAndGetAuthor(Author author) {
		Author foundAuthor = findAuthorByNames(author.getFirstName(), author.getLastName());
		if(foundAuthor == null) {
			addAuthor(author);
			return author;
		} else {
			return foundAuthor;
		}
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

		Book b1 = new Book("Thinking in Java 4ed.", 
				new Author[] {new Author("Bruce", "Eckel")}, 2006);
		System.out.println(b1);
		Book b2 = new Book("Algorithms + Data Structures = Programs", 
				new Author[] {new Author("Niklaus", "Wirth")}, 1976, 
				"ISBN 978-0-13-022418-7", "Prentice-Hall", Genre.SOFTWARE, 
				new String[] {"programming", "algorithm", "data structure", "classic"});
		System.out.println(b2);

		// for(Book book : library.getAllBooks()) {
		// System.out.println(book);
		// }

		library.inputNewBook();

		System.out.println(formatAsTable(library.getAllBooks()));

	}

}
