package mylibrary;
import java.util.Arrays;

import mylibrary.model.Author;
import mylibrary.model.Book;

public class Library {
	public static final int CAPACITY = 1000;
	private static long nextId = 1; 
	private static long nextAuthorId = 1; 
	
	private Book[] books = new Book[CAPACITY];
	private Author[] authors = new Author[CAPACITY];
	private int bookCount = 0;
	private int authorCount = 0;
	
	public Book addBook(Book book) {
		Author[] authors = book.getAuthors();
		Author[] allAuthors = getAllAuthors();
		for(int i = 0; i < authors.length; i++) {
			int j;
			for(j = 0; j < allAuthors.length; j++) {
				if(authors[i].equals(allAuthors[j]))  { //exiting author found
					authors[i] = allAuthors[j];
					break;
				}
			}
			if(j == allAuthors.length) { // author not found
				addAuthor(authors[i]);
			}
		}
		book.setId(nextId ++);
		books[bookCount ++] = book;
		return book;
	}
	
	public Book[] findBooksByTitle(String titleSubstring) {
		Book[] results = new Book[CAPACITY];
		int count = 0;
		for(int i = 0; i < bookCount; i++) {
			if(books[i].getTitle().indexOf(titleSubstring) >= 0) { // matching book found
				results[count++] = books[i];
			}
		}
		return Arrays.copyOf(results, count);
	}
	
	public Author addAuthor(Author author) {
		author.setId(nextAuthorId ++);
		authors[authorCount ++] = author;
		return author;
	}
	
	public Book[] getAllBooks() {
		return Arrays.copyOf(books, bookCount);
	}
	
	public Author[] getAllAuthors() {
		return Arrays.copyOf(authors, authorCount);
	}
	
	public int getBookCount() {
		return bookCount;
	}
	
	public String getReport() {
		StringBuilder result = new StringBuilder(
				"| id |             Title                 |             Authors            |    Genre    | Year |\n");
		result.append
			   ("+----+-----------------------------------+--------------------------------+-------------+------+\n");
		for(Book b : getAllBooks()) {
			StringBuilder authorBuilder = new StringBuilder();
			Author[] authors = b.getAuthors();
			for(int i = 0; i < authors.length; i++) {
				if(i > 0) {
					authorBuilder.append(", ");
				}
				authorBuilder.append(authors[i].getFirstName().charAt(0))
				.append(". ").append(authors[i].getLastName());
			}
			
			result.append(
				String.format(
				"|%3d |%-34.34s |%-31.31s |%12.12s | %4d |\n", 
					b.getId(), b.getTitle(), authorBuilder.toString(), b.getGenre(), b.getYear()));
		}
		return result.toString();
	}
	
	public static Author[] convertStringToAuthors(String authorStr) {
		String[] authors = authorStr.split("\\s*,\\s*");
		Author[] result = new Author[authors.length];
		for(int i = 0; i < authors.length; i++) {
			authors[i] = authors[i].trim();
			String[] names = authors[i].split("\\s+");
			result[i] = new Author(names[0], names[names.length-1]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Library lib = new Library();
		lib.addBook(new Book("Thinking in Java 4ed.", "Bruce Eckel"));
		lib.addBook(new Book("Въведение в програмирането с Java", "Светлин   Наков , Михаил Стойнов, Марио Пешев "));
		lib.addBook(new Book("Alice in Wonderland", "Lewis Carroll"));
		lib.addBook(new Book("Thinking in C++ 3ed.", "  Bruce    Eckel   "));

		System.out.println(lib.getReport());
		
		Book[] foundBooks = lib.findBooksByTitle("Thinking");
		for(Book b: foundBooks) {
			System.out.println(b);
		}
		
		System.out.println("Same author: " + (foundBooks.length == 2 && 
				foundBooks[0].getAuthors()[0] == foundBooks[1].getAuthors()[0]));
		
	}

}
