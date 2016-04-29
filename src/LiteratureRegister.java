import java.util.ArrayList;

/**
 * Holds the list of literatures.
 * You are able to print out the list alphabetically or by price
 * You can search for literatures by  author name, surname and/or last name,
 * by literature title, partial title allowed, and by publisher.
 * Generic search searches within author, title and publisher. 
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen, Asbjørn Frostad
 * @version 0.4, 2016-04-08
 */
public class LiteratureRegister
{
    private final ArrayList<Literature> literatureList;
    /**
     * Creates a list of the current literatures that re being sold.
     */
    public LiteratureRegister()
    {
        literatureList = new ArrayList<>();
    }
    /**
     * Prints out a list containing all literatures, complete with author name, title and price.
     * @param literature The literature u want to add.
     */
    public void add(Literature literature)
    {
        literatureList.add(literature);
    }
    /**
     * Prints out a list containing all literatures, complete with author name, title and price.
     * Returns the removed literature.
     * @param title The title of the literature you want to remove.
     * @return the removed literature.
     */
    public Literature remove(String title)
    {
        Literature literatureToRemove = null;
        for(Literature literature : literatureList)
        {
            if(literature.getTitle().toLowerCase().equals(title.toLowerCase()))
            {
                literatureToRemove = literature;
            }
        }
        if(null != literatureToRemove);
        {
            Literature literatureToReturn = literatureToRemove;
        literatureList.remove(literatureToRemove);
        return literatureToReturn;
        }
    }
    /**
     * Returns the list of literatures.
     * @return the list of literatures.
     */
    public ArrayList<Literature> listAllLiteratures()
    {
        ArrayList<Literature> listToReturn = new ArrayList<>();
        for(Literature literature : literatureList)
        {
           listToReturn.add(literature);
        }
        return listToReturn;
    }
    
    /**
     * Find literature searching by title
     * @param title Title of the literature
     * @return the literature you find as a string
     */
    public Literature findLiterature(String title)
    {
        Literature literatureToReturn = null;
        for(Literature literature : literatureList)
        {
            if(literature.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                literatureToReturn = literature;
            }
        }
        return literatureToReturn;
    }
}
