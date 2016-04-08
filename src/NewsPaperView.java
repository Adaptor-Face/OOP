/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asbjørn
 */
public class NewsPaperView {
   
    
    /**
     * 
     */
    public NewsPaperView() {
        
    }
    
    /**
     * 
     */
    public String getInfo(NewsPaper newspaper) {
        return "Title: " + newspaper.getTitle() + " Price: " + newspaper.getPrice() + "\nPublisher: " + newspaper.getPublisher();
    }
    
     /**
     * 
     */
    public String getDetails(NewsPaper newspaper) {
        return "Title: " + newspaper.getTitle() + " Price: " + newspaper.getPrice() + "\nYear published: " + newspaper.getDate()
                + "\nNumber of pages: " + newspaper.getNumberOfPages() + " Publisher: " + newspaper.getPublisher();
    }
}
