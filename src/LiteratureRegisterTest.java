
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LiteratureRegisterTest.
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad
 * @version 2016-03-04
 */
public class LiteratureRegisterTest
{
    private LiteratureRegister testRegister;
    /**
     * Default constructor for test class LiteratureRegisterTest
     */
    public LiteratureRegisterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        testRegister = new LiteratureRegister();
        testRegister.addNewBook(new Book("WORLD", "David Jones", 255, 2010, 19.99, "Volvo"));
        testRegister.addNewBook(new Book("Underground", "Jenny Garden", 200, 1999, 9.99, "Dom"));
        testRegister.addNewBook(new Book("Universe", "Steven Hawking", 650, 1699, 29.99, "Marvel"));
        testRegister.addNewBook(new Book("Voice work", "Morgan Freeman", 100, 2000, 25.99, "Marvel"));
        testRegister.addNewBook(new Book("Cartoons", "David Moffat", 65, 2015, 39.99, "Pearson"));
        testRegister.addNewBook(new Book("Combine", "Gordon Freeman", 120, 2011, 15.99, "Valve"));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testRemoveBook()
    {
        LiteratureRegister literatu1 = new LiteratureRegister();
        literatu1.addNewBook(new Book("lol", "haha", 24, 2016, 123.5, "asbjørn"));
        assertEquals("Removed lol, by haha from our listings.", literatu1.removeBookFromList("lol"));
    }

    @Test
    public void testGenericSearch()
    {
        assertEquals("Matching books searching for Combine:Title: Combine, Author: Gordon Freeman. Price: 15.99,-", testRegister.genericSearch("Combine"));
    }

    @Test
    public void testSearchAuthor()
    {
        assertEquals("Matching books from author Gordon Freeman:Title: Combine, Author: Gordon Freeman. Price: 15.99,-", testRegister.searchAuthor("Gordon Freeman"));
    }

    @Test
    public void searchTitleTest()
    {
        assertEquals("Matching books with the title Combine: Title: Combine, Author: Gordon Freeman, Price: 15.99,-", testRegister.searchByTitle("Combine"));
    }

    @Test
    public void searchPublisherTest()
    {
        assertEquals("Matching books from publisher Pearson:Title: Cartoons, Author: David Moffat. Price: 39.99,-", testRegister.searchPublisher("Pearson"));
    }

    @Test
    public void negativeRemoveBookTest()
    {
        assertEquals("There was no book with the title of lasjd", testRegister.removeBookFromList("lasjd"));
    }

}


