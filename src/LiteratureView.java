
/**
 * Is a string generator
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad
 * @version 0.4, 2016-04-08
 */
public class LiteratureView {

    /**
     * 
     */
    public LiteratureView() {
    }

    /**
     * Generating a string with information of given literature type
     *
     * @param literature The literature you want to generate information string
     * from
     * @return a string containing information from the given literature
     */
    public String getInfo(Literature literature) {
        String stringToReturn = "Nothing to see here, move along.";
        if (literature instanceof Book) {
            Book book = (Book) literature;
            stringToReturn = "Title: " + book.getTitle() + " Author: " + book.getAuthor()
                    + "\nPrice: " + book.getPrice();
        } else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            stringToReturn = "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice()
                    + "\nPublisher: " + magazine.getPublisher();
        } else if (literature instanceof NewsPaper) {
            NewsPaper newsPaper = (NewsPaper) literature;
            stringToReturn = "Title: " + newsPaper.getTitle() + " Price: " + newsPaper.getPrice() + "\nPublisher: " + newsPaper.getPublisher();
        }
        return stringToReturn;
    }

    /**
     * Generating a string with all information of given literature type
     *
     * @param literature The literature you want to generate information string
     * from
     * @return a string containing all information from the given literature
     */
    public String getDetails(Literature literature) {
        String stringToReturn = "Nothing to see here, move along.";
        if (literature instanceof Book) {
            Book book = (Book) literature;
            stringToReturn = "Title: " + book.getTitle() + " Author: " + book.getAuthor()
                    + "\nPrice: " + book.getPrice() + "Year published: " + book.getYearPublished()
                    + "\nNumber of pages: " + book.getNumberOfPages() + " Publisher: " + book.getPublisher();
        } else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            stringToReturn = "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice()
                    + "\nNumber of pages: " + magazine.getNumberOfPages() + " Publisher: " + magazine.getPublisher();
        } else if (literature instanceof NewsPaper) {
            NewsPaper newsPaper = (NewsPaper) literature;
            stringToReturn = "Title: " + newsPaper.getTitle() + " Price: " + newsPaper.getPrice() + "\nYear published: " + newsPaper.getDate()
                    + "\nNumber of pages: " + newsPaper.getNumberOfPages() + " Publisher: " + newsPaper.getPublisher();
        }
        return stringToReturn;
    }

}
