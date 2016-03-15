import java.util.ArrayList;


/**
 * Handles the lists of various literature types.
 * currently only handles the book type literature.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.1, 2016-03-04
 */
public class NewsStand 
{
    private LiteratureRegister literatureList;
    /**
     * 
     */
    public NewsStand() {
        literatureList = new LiteratureRegister();
    }

    /**
     * Get list of all literature in the register
     */
    public String getList() {
        ArrayList<Literature> literatureList = this.literatureList.listAllLiteratures();
        String listOfliterature = "";
        for(Literature literature: literatureList)
        {
            listOfliterature += literature.getInfo();
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
     * @param title The title of the book.
     * @param author The name of the author.
     * @param numberOfPages Number of pages in the book.
     * @param yearPublished Pubilsh year of the book.
     * @param price The price of the book in NOK.
     * @param publisher The name of the publisher of the book.
     */
    public void addLiteratureToList(String title, String author, int numberOfPages,
    int yearPublished, double price, String publisher) {
    }
    
    /**
     * Remove a book from the register
     * @param bookTitle Title of the book
     * Returns a string explaining which book you removed
     * @return A string explaining which book you removed
     */
    public String removeLiterature(String bookTitle) {
        return "FIX ME! REMOVELITERATURE";
    }
    
    /**
     * Search for literature by title
     * @param title Title of the book
     * Returns title of the book
     * @return title of the book
     */
    public String searchLiteratureByTitle(String title) {
        return "FIX ME! SEARCH BY TITLE!";
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
