/**
 * Abstract class representing common traits among all literature
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen, Asbjørn Frostad
 * @version 0.4, 2016-04-08
 */
public abstract class Literature {
    private final String title;
    private double price;
    private final String publisher;
    private final int numberOfPages;
    /**
     * Creates literature with the given title, number of pages, 
     * the cost of the literature and the name of the publisher.
     * @param title The title of the literature.
     * @param publisher The name of the publisher of the literature.
     * @param numberOfPages Number of pages in the literature.
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
     * Sets a new price for the literature.
     * @param price The price of the literature in NOK.
     */
    public void setNewPrice(double price)
    {
        this.price = price;
    }

    /**
     * Returns the title of the literature.
     * @return the title of the literature.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the cost of the  literature (in NOK).
     * @return The cost of the  literature as double datatype. (in NOK)
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the publish year of the literature.
     * @return the publish year of the literature.
     */
    public String getPublisher()
    {
        return publisher;
    }

    /**
     * Returns the number of pages in the literature.
     * @return the number of pages in the literature as an int.
     */
    public int getNumberOfPages()
    {
        return numberOfPages;
    }
}
