/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asbjørn
 */
public class BookView {
    
    
    /**
     * 
     */
    public BookView() {
    }
    
    /**
     * 
     * @return the details of the book.
     */
    public String getInfo(Book book) {
        return "Title: " + book.getTitle() + " Author: " + book.getAuthor()
                + "\nPrice: " + book.getPrice();
    }
    
    /**
     * 
     * @return the details of the book.
     */
    public String getDetails(Book book) {
        return "Title: " + book.getTitle() + " Author: " + book.getAuthor()
                + "\nPrice: " + book.getPrice() + "Year published: " + book.getYearPublished()
                + "\nNumber of pages: " + book.getNumberOfPages() + " Publisher: " + book.getPublisher();
    }
}
