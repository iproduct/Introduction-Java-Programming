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
		book.setId(nextId ++);
		books[bookCount ++] = book;
		return book;
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
	
	public static void main(String[] args) {
		Library lib = new Library();
		Author bruce = lib.addAuthor(new Author("Bruce", "Eckel"));
		Author svetlin = lib.addAuthor(new Author("Светлин", "Наков"));
		Author misho = lib.addAuthor(new Author("Михаил", "Стойнов"));
		Author lewis = lib.addAuthor(new Author("Lewis", "Carroll"));
		lib.addBook(new Book("Thinking in Java 4ed.", new Author[] {bruce}));
		lib.addBook(new Book("Въведение в програмирането с Java", new Author[] {svetlin, misho}));
		lib.addBook(new Book("Alice in Wonderland", new Author[] {lewis}));
		System.out.println(lib.getReport());
	}

}
