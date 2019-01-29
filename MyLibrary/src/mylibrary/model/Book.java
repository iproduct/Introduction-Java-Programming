package mylibrary.model;

import static mylibrary.model.Genre.*;

import java.util.Arrays;

public class Book extends Object {
	// 1. Attributes
	private long id;
	private String title;
	private Author[] authors = new Author[0];
	private Genre genre = OTHER;
	private int year;
	private String publisher;
	private String description;
	private String[] keywords = new String[] {};
	
	// 2. Constructors
	public Book() { //Noarg constructor
	}

	public Book(String title, Author[] authors) {
		this.title = title;
		this.authors = authors;
	}

	public Book(String title, Author[] authors, Genre genre, int year, String publisher, String description,
			String[] keywords) {
		this.title = title;
		this.authors = authors;
		this.genre = genre;
		this.year = year;
		this.publisher = publisher;
		this.description = description;
		this.keywords = keywords;
	}

	public Book(long id, String title, Author[] authors, Genre genre, int year, String publisher, String description,
			String[] keywords) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.genre = genre;
		this.year = year;
		this.publisher = publisher;
		this.description = description;
		this.keywords = keywords;
	}
	
	// 3. get and set methods
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

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	// 4. hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
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
		Book other = (Book) obj; //down casting
		if (!Arrays.equals(authors, other.authors))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	// 5. toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=").append(id).append(", title=").append(title).append(", authors=")
				.append(Arrays.toString(authors)).append(", genre=").append(genre).append(", year=").append(year)
				.append(", publisher=").append(publisher);
		return builder.toString();
	}
	
}
