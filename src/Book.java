
/**
 * Holds the title, author name, number of pages, the cost, 
 * publish year of a book and the name of the publisher.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */
public class Book extends Literature
{
    private final int yearPublished;
    private final String author;
    /**
     * Creates a new book with the given title, author, number of pages, 
     * the publish year, the cost of the book and the name of the publisher.
     * @param author The name of the author.
     * @param yearPublished Pubilsh year of the book.
     * @param title The title of the book.
     * @param numberOfPages The number of pages in the book.
     * @param price The price of the book.
     * @param publisher The publisher of the book.
     */
    public Book(String title, String author, int numberOfPages, 
    int yearPublished, double price, String publisher)
    {
        super(title, price, publisher, numberOfPages);
        this.author = author;
        this.yearPublished = yearPublished;
    }

    /**
     * Returns the authors name.
     * @return the authors name.
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Returns the publish year of the book.
     * @return the publish year of the book as an int.
     */
    public int getYearPublished()
    {
        return yearPublished;
    }
}
