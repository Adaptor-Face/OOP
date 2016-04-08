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
    
   private Magazine magazine;
   
   
   /**
    * 
    */
    public MagazineView(Magazine magazine) {
        this.magazine = magazine;
    }
    
    /**
     * 
     */
    public String getInfo() {
        return "Title: " + magazine.getTitle() + " Price: " + magazine.getPrice() 
            + "\nNumber of pages: " + magazine.getNumberOfPages() + " Publisher: " + magazine.getPublisher();
    }
}
