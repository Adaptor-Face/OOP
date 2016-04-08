/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asbjørn
 */
public class NewsPaper extends Literature {
    
    private final int yearPublished;
    
    
    /**
     * Creates an object of type NewsPaper.
     * @param title title of newspaper.
     * @param price of newspaper.
     * @param publisher name of publisher.
     * @param numberOfPages the number of pages in the newspaper.
     * @param yearPublished the year the newspaper was published in.
     */
    public NewsPaper(String title, double price, String publisher, int numberOfPages,int yearPublished) {
        super(title, price, publisher, numberOfPages);
        this.yearPublished = yearPublished;
    }
    
    
    /**
     * returns the year the newspaper was published
     * @return the year the newspaper was published
     */
    public int getYearPublished() {
        return yearPublished;
    }
    
    /**
     *
     * @return lol
     */
    @Override
   public String getInfo()
   {
       NewsPaperView view = new NewsPaperView();
        String infoString = view.getInfo(this);
        return infoString;
   }
   
   /**
     * Returns all info about the book.
     * @return all info about the book.
     */
    @Override
    public String getDetails()
    {
         NewsPaperView view = new NewsPaperView();
        String infoString = view.getDetails(this);
        return infoString;
    }
}
