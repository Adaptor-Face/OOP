
/**
 * Is a string generator
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad
 * @version 0.4, 2016-04-08
 */
public class StringFactory {

    /**
     * Creates a object responsible of generating information strings
     */
    public StringFactory() {
    }
    /**
     * Creates the info string for any literature.
     * @param literature The literature to create an info string for.
     * @return the info string for any literature.
     */
    public String getInfo(Literature literature) {
        String stringToReturn = "Title: " + literature.getTitle()
                + getInfoFromLiterature(literature)
                    + "\nPrice: " + literature.getPrice();
        return stringToReturn;
    }
    
    /**
     * Creates a string of all details any literature has.
     * @param literature The literature to create a detail string for.
     * @return a string of all details any literature has.
     */
    public String getDetails(Literature literature) {
        String stringToReturn = "Title: " + literature.getTitle();
        stringToReturn += getLiteratureDetails(literature);
        stringToReturn += "\nPublisher: " + literature.getPublisher();
        stringToReturn += " Number of pages: " + literature.getNumberOfPages(); 
        stringToReturn += "\nPrice: " + literature.getPrice();
        return stringToReturn;
    }

    /**
     * Creates a string of only necessary information any literature may hold.
     * Returns an empty string if the literature has nothing important to show.
     * @param literature The literature to get the info from.
     * @return a string of only necessary information any literature may hold.
     */
    private String getInfoFromLiterature(Literature literature) {
        if (literature instanceof Book) {
            Book book = (Book) literature;
            return (String) " Author: " + book.getAuthor();
            
        }else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            return (String) " Publisher: " + magazine.getPublisher();
            
        }else if (literature instanceof NewsPaper) {
            NewsPaper newsPaper = (NewsPaper) literature;
            return (String) " Publisher: " + newsPaper.getPublisher();
        }
        return "";
    }
    
    /**
     * Creates a string of all information any literature may hold.
     * Returns an empty string if the literature has nothing important to show.
     * @param literature The literature to get the details from.
     * @return a string of all information any literature may hold.
     */
    private String getLiteratureDetails(Literature literature) {
        String returnString = "";
        if (literature instanceof Book) {
            Book book = (Book) literature;
            return (String) " Author: " + book.getAuthor()
                    + " Published: " + book.getYearPublished();
            
        }else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            return (String) " Published: " + magazine.getDatePublished()
                    + " Issue nr: " + magazine.getIssue();
            
        }else if (literature instanceof NewsPaper) {
            NewsPaper newsPaper = (NewsPaper) literature;
            return (String) " Published: " + newsPaper.getDatePublished();
        }
        
        return returnString;
    }
}
