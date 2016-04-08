/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asbjørn
 */
public class View {
    
    private Literature literature;
    
    
    /**
     * 
     * 
     */
    public View() {
        
        
    }
    /**
     * 
     * @return the title of the literature.
     */
    public String getTitle() {
        
        return literature.getTitle();
    }
    
    
    /**
     * 
     * @return the author of the literature.
     */
    public String getPublisher() {
        return literature.getPublisher();
    }
    
    
    /**
     * 
     * @return The price of the literature.
     */
    public double getPrice() {
        return literature.getPrice();
    }
    
    /**
     * @return The number of pages of the literature.
     */
    public int getNumberOfPages() {
        return literature.getNumberOfPages();
    }
    
    
    /**
     *@return the details of the literature.
     */
    public String getInfo(Literature literature) {
        
    }
    
    
}
