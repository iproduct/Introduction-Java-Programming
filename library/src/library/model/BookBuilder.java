package library.model;

public class BookBuilder {
	private Book book = new Book();

	public BookBuilder() {
	}

	public BookBuilder(Book aBook) {
		this.book = aBook;
	}

	public BookBuilder addTitle(String title) {
		book.setTitle(title);
		return this;
	}

	public BookBuilder addAuthor(String newAuthor) {
		String oldAuthors = book.getAuthors();
		if(oldAuthors == null )	{ // Lazy initilization
			book.setAuthors(newAuthor);
		} else {
			book.setAuthors( oldAuthors + ", " + newAuthor);
		}
		return this;
		
	}
	public BookBuilder addYear(int year) {
		book.setYear(year);
		return this;
	}

	public Book getBook() {
		return book;
	}

	public static void main(String[] args) {
		BookBuilder builder = new BookBuilder();
		Book newBook = builder.addTitle("Head First Java, 2ed.")
				.addAuthor("Kathy Sierra")
				.addAuthor("Bert Bates")
				.addYear(2005)
				.getBook();
		System.out.println(newBook);

	}

}
