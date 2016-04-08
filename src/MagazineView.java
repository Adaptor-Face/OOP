/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asbjørn
 */
public class MagazineView {
    
   
   
   
   /**
    * 
    */
    public MagazineView() {
        
    }
    
    /**
     * 
     */
    public String getInfo(Magazine magazine) {
        return "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice() 
            + "\nPublisher: " + magazine.getPublisher();
    }
    
    /**
     * 
     */
     public String getDetails(Magazine magazine) {
        return "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice() 
            + "\nNumber of pages: " + magazine.getNumberOfPages() + " Publisher: " + magazine.getPublisher();
    }
}
