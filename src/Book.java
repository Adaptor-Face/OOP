
/**
 * Holds the title, author name, number of pages, the cost, 
 * publish year of a book and the name of the publisher.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.1, 2016-02-12
 */
public class Book
{
    private final String title;
    private final int yearPublished;
    private double price;
    private final String author;
    private int numberOfPages;
    private final int edition;
    private final String publisher;
    /**
     * Creates a new book with the given title, author, number of pages, 
     * the publish year, the cost of the book and the name of the publisher.
     * @param title The title of the book.
     * @param author The name of the author.
     * @param numberOfPages Number of pages in the book.
     * @param yearPublished Pubilsh year of the book.
     * @param publisher The name of the publisher of the book.
     */
    public Book(String title, String author, int numberOfPages, 
    int yearPublished, double price, String publisher)
    {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.yearPublished = yearPublished;
        edition = 0;
        this.publisher = publisher;
    }

    /**
     * Sets a new price for the book.
     * @param price The price of the book in NOK.
     */
    public void setNewPrice(double price)
    {
        this.price = price;
    }

    /**
     * Returns the title of the book.
     * @return the title of the book.
     */
    public String getTitle()
    {
        return title;
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
     * Returns the cost of the  book (in NOK).
     * @return The cost of the  book as double datatype. (in NOK)
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the publish year of the book.
     * @return the publish year of the book as an int.
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Returns the number of pages in the book.
     * @return the number of pages in the book as an int.
     */
    public int getNumberOfPages()
    {
        return numberOfPages;
    }

    /**
     * Returns the publish year of the book.
     * @return the publish year of the book.
     */
    public String getPublisher()
    {
        return publisher;
    }
}
