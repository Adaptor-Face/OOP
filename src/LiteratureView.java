/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Face
 */
public class LiteratureView {
    public LiteratureView()
            {
                
            }
            
    public String getInfo(Literature literature) {
        String stringToReturn = "Nothing to see here, move along.";
        if(literature instanceof Book)
        {
            Book book = (Book) literature;
            stringToReturn = "Title: " + book.getTitle() + " Author: " + book.getAuthor()
                + "\nPrice: " + book.getPrice();
        }else if(literature instanceof Magazine)
        {
            Magazine magazine = (Magazine) literature;
            stringToReturn = "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice() 
            + "\nPublisher: " + magazine.getPublisher();
        }else if(literature instanceof NewsPaper)
        {
            NewsPaper newsPaper = (NewsPaper) literature;
            stringToReturn = "Title: " + newsPaper.getTitle() + " Price: " + newsPaper.getPrice() + "\nPublisher: " + newsPaper.getPublisher();
        }
        return stringToReturn;
    }
    public String getDetails(Literature literature) {
        String stringToReturn = "Nothing to see here, move along.";
        if(literature instanceof Book)
        {
            Book book = (Book) literature;
            stringToReturn = "Title: " + book.getTitle() + " Author: " + book.getAuthor()
                + "\nPrice: " + book.getPrice() + "Year published: " + book.getYearPublished()
                + "\nNumber of pages: " + book.getNumberOfPages() + " Publisher: " + book.getPublisher();
        }else if(literature instanceof Magazine)
        {
            Magazine magazine = (Magazine) literature;
            stringToReturn = "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice() 
            + "\nNumber of pages: " + magazine.getNumberOfPages() + " Publisher: " + magazine.getPublisher();
        }else if(literature instanceof NewsPaper)
        {
            NewsPaper newsPaper = (NewsPaper) literature;
            stringToReturn = "Title: " + newsPaper.getTitle() + " Price: " + newsPaper.getPrice() + "\nYear published: " + newsPaper.getDate()
                + "\nNumber of pages: " + newsPaper.getNumberOfPages() + " Publisher: " + newsPaper.getPublisher();
        }
        return stringToReturn;
    }
    
}
