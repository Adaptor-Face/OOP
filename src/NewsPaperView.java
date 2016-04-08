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
    private NewsPaper newspaper;
    
    /**
     * @param newspaper the newspaper.
     */
    public NewsPaperView(NewsPaper newspaper) {
        this.newspaper = newspaper;
    }
    
    /**
     * 
     */
    public String getInfo() {
        return "Title: " + newspaper.getTitle() + " Price: " + newspaper.getPrice() + "\nYear published: " + newspaper.getYearPublished()
                + "\nNumber of pages: " + newspaper.getNumberOfPages() + " Publisher: " + newspaper.getPublisher();
    }
}
