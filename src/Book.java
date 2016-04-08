
/**
 * Holds the title, author name, number of pages, the cost, 
 * publish year of a book and the name of the publisher.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.1, 2016-02-12
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
    
    /**
     * Returns all info about the book.
     * @return all info about the book.
     */
    public String getInfo()
    {
        String infoString = getTitle() + ", by: " + this.getAuthor() 
                + "\n" + getPrice();
        return infoString;
    }
}
