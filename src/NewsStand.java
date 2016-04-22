import java.util.ArrayList;


/**
 * Handles the lists of various literature types.
 * currently only handles the book type literature.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */
public class NewsStand 
{
    private final LiteratureRegister literatureList;
    /**
     * Creates an instance of the newsstand
     */
    public NewsStand() {
        literatureList = new LiteratureRegister();
    }

    /**
     * Get list of all literature in the register
     * @return returns a list of all literature in the register as a string
     */
    public String getList() {
        ArrayList<Literature> temporaryLiteratureList = this.literatureList.listAllLiteratures();
        String listOfliterature = "";
        StringFactory builder = new StringFactory();
        for(Literature literature: temporaryLiteratureList)
        {
            listOfliterature += builder.getInfo(literature);
        }
        if(listOfliterature.equals(""))
        {
            return "There are no literature to list.";
        }
        return listOfliterature;
    }
    
    /**
     * Add new book to register with given title, author, number of pages, 
     * the publish year, the cost of the book and the name of the publisher.
     * @param literature The literature to add to the lists.
     */
    public void addLiteratureToList(Literature literature) {
        literatureList.add(literature);
    }
    
    /**
     * Remove a book from the register
     * @param title Title of the book
     * Returns a string explaining which book you removed
     * @return which book you removed as a string
     */
    public Literature removeLiterature(String title) {
       return literatureList.remove(title);
    }
    
    /**
     * Search for literature by title
     * @param title Title of the book
     * Returns title of the book
     * @return title of the book as a string
     */
    public Literature searchLiteratureByTitle(String title) {
        return literatureList.findLiterature(title);
    }
    
    /**
     * Search for literature written by given author
     * @param authorName Name of the author 
     * Returns literature written by given author 
     * @return literature written by given author
     */
    public String searchliteratureByAuthor(String authorName) {
        return "FIX ME! AUTHOR SEARCH!";
    }
    
    /**
     * Search for literature by publisher
     * @param publisher Name of the publisher
     * Returns literature published by given publisher
     * @return literature published by given publisher
     */
    public String searchLiteratureByPublisher(String publisher) {
        return "FIX ME! PUBLISHER SEARCH!";
    }
    
    /**
     * Generic search for literature
     * @param search Generic searchword
     * Returns literature by given searchword
     * @return literature by given searchword
     */
    public String searchLiteratureByAnything(String search) {
        return "FIX ME! GENERIC SEARCH!";
    }

}
