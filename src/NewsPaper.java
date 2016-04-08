/**
 * Holds the title, number of pages, the cost, 
 * and the published date of the newspaper
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */
public class NewsPaper extends Literature {
    
    private final String date;
    
     /**
     * Creates an object of type NewsPaper.
     * @param title title of newspaper.
     * @param price of newspaper.
     * @param publisher name of publisher.
     * @param numberOfPages the number of pages in the newspaper.
     * @param date the date the newspaper was published in.
     */
    public NewsPaper(String title, double price, String publisher, int numberOfPages,String date) {
        super(title, price, publisher, numberOfPages);
        this.date = date;
    }
    
    
    /**
     * Returns the date the newspaper was published
     * @return the date the newspaper was published as a string
     */
    public String getDate() {
        return date;
    }
}
