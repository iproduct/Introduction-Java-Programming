package library.model;

import java.util.Arrays;

public class Book {
	private static long nextId = 1;
	
	private long id = nextId++;
	private String title;
	private String authors = "anonimous";
	private int year;
	private String isbn;
	private String publisher;
	private Genre genre;
	private String[] tags;

	//No arg constructor
	public Book() { 
	}

	// Mandatory args constructor
	public Book(String title, String authors, int year) {
		this.title = title;
		this.authors = authors;
		this.year = year;
	}
	
	// Full constructors
	public Book(String title, String authors, int year, String isbn, String publisher, Genre genre, String[] tags) {
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.isbn = isbn;
		this.publisher = publisher;
		this.genre = genre;
		this.tags = tags;
	}

	public Book(long id, String title, String authors, int year, String isbn, String publisher, 
			Genre genre, String[] tags) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.isbn = isbn;
		this.publisher = publisher;
		this.genre = genre;
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=").append(id).append(", ");
		builder.append("title=").append(title).append(", ");
		builder.append("authors=").append(authors).append(", ");
		builder.append("year=").append(year).append(", ");
		if (isbn != null)
			builder.append("isbn=").append(isbn).append(", ");
		if (publisher != null)
			builder.append("publisher=").append(publisher).append(", ");
		if (genre != null)
			builder.append("genre=").append(genre).append(", ");
		if (tags != null)
			builder.append("tags=").append(Arrays.toString(tags));
		builder.append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		Book b1 = new Book("Thinking in Java 4ed.", "Bruce Eckel", 2006);
		System.out.println(b1);
		
		Book b2 = new Book("Algorithms + Data Structures = Programs", "Niklaus Wirth", 1976, 
				"ISBN 978-0-13-022418-7", "Prentice-Hall", Genre.SOFTWARE, 
				new String[] {"programming", "algorithm", "data structure", "classic"});
		System.out.println(b2);
	}

	
}
