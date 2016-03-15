import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
     */
    public void listAllLiterature()
    {
    System.out.println();
    if (literatureList.size() <= 0)
    {
        System.out.println("There is no literatures.");
    }
    for(Literature literature : literatureList)
    {
        System.out.println(literature.getInfo());
    }
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
}