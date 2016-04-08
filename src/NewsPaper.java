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
     * @return the date the newspaper was published
     */
    public String getdate() {
        return date;
    }
    
    /**
     * Returns information of the newspaper
     * @return information of the newspaper
     */
    @Override
   public String getInfo()
   {
       NewsPaperView view = new NewsPaperView();
        String infoString = view.getInfo(this);
        return infoString;
   }
   
   /**
     * Returns details about the book.
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
