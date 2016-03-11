import java.util.ArrayList;


/**
 * Handles the lists of various literature types.
 * currently only handles the book type literature.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.1, 2016-03-04
 */
public class NewsStand 
{
    private LiteratureRegister books;
    /**
     * 
     */
    public NewsStand() {
        books = new LiteratureRegister();
    }

    /**
     * Get list of all books in the register
     */
    public String getList() {
        ArrayList<Book> literatureList = books.listAllBooks();
        String listOfBooks = "";
        for(Book book: literatureList)
        {
            listOfBooks += "Title: " + book.getTitle() + ", Author: " 
                + book.getAuthor() + ", Price: " + book.getPrice() + ",-\n";
        }
        if(listOfBooks.equals(""))
        {
            return "There are no books to list.";
        }
        return listOfBooks;
    }
    
    /**
     * Add new book to register with given title, author, number of pages, 
     * the publish year, the cost of the book and the name of the publisher.
     * @param title The title of the book.
     * @param author The name of the author.
     * @param numberOfPages Number of pages in the book.
     * @param yearPublished Pubilsh year of the book.
     * @param price The price of the book in NOK.
     * @param publisher The name of the publisher of the book.
     */
    public void addBookToList(String title, String author, int numberOfPages,
    int yearPublished, double price, String publisher) {
        Book newBook = new Book(title, author, numberOfPages, yearPublished, price, publisher);
        books.addNewBook(newBook);
    }
    
    /**
     * Remove a book from the register
     * @param bookTitle Title of the book
     * Returns a string explaining which book you removed
     * @return A string explaining which book you removed
     */
    public String removeBook(String bookTitle) {
        return books.removeBookFromList(bookTitle);
    }
    
    /**
     * Search for books by title
     * @param title Title of the book
     * Returns title of the book
     * @return title of the book
     */
    public String searchBookByTitle(String title) {
        return books.searchByTitle(title);
    }
    
    /**
     * Search for books written by given author
     * @param authorName Name of the author 
     * Returns books written by given author
     * @return books written by given author
     */
    public String searchBooksByAuthor(String authorName) {
        return books.searchAuthor(authorName);
    }
    
    /**
     * Search for books by publisher
     * @param publisher Name of the publisher
     * Returns books published by given publisher
     * @return books published by given publisher
     */
    public String searchBookByPublisher(String publisher) {
        return books.searchPublisher(publisher);
    }
    
    /**
     * Generic search for books
     * @param search Generic searchword
     * Returns books by given searchword
     * @return books by given searchword
     */
    public String searchBookByAnything(String search) {
        return books.genericSearch(search);
    }

}
