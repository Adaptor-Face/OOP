/**
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */
public abstract class Literature {
    private final String title;
    private double price;
    private final String publisher;
    private final int numberOfPages;
    /**
     * Creates a new book with the given title, author, number of pages, 
     * the publish year, the cost of the book and the name of the publisher.
     * @param title The title of the this.
     * @param publisher The name of the publisher of the this.
     * @param numberOfPages Number of pages in the book.
     * @param price The price of the this in NOK.
     */
    
    public Literature(String title, double price, String publisher, int numberOfPages)
    { 
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
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
     * Returns the cost of the  book (in NOK).
     * @return The cost of the  book as double datatype. (in NOK)
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the publish year of the book.
     * @return the publish year of the book.
     */
    public String getPublisher()
    {
        return publisher;
    }

    /**
     * Returns the number of pages in the book.
     * @return the number of pages in the book as an int.
     */
    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    public abstract String getInfo();
}
