import java.util.ArrayList;

/**
 * Holds the list of literatures.
 * You are able to print out the list alphabeticaly or by price
 * You can search for literatures by  author name, surname and/or last name,
 * by literature title, partial title allowed, and by publisher.
 * Generic search searches within author, title and publisher. 
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.2, 2016-03-04
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
     * Returns the list of literatures.
     * @return the list of literatures.
     */
    public ArrayList<Literature> listAllLiteratures()
    {
        ArrayList<Literature> listToReturn = new ArrayList<Literature>();
        for(Literature literature : literatureList)
        {
           listToReturn.add(literature);
        }
        return listToReturn;
    }
    
    public Literature findLiterature(String title)
    {
        Literature literatureToReturn = null;
        for(Literature literature : literatureList)
        {
            if(literature.getTitle().toLowerCase().equals(title))
            {
                literatureToReturn = literature;
            }
        }
        return literatureToReturn;
    }
}