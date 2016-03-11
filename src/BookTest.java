

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookTest.
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad
 * @version 2016-03-04
 */
public class BookTest
{
    private Book book1;

    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
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
        book1 = new Book("Test title", "Oracle", 42, 1999, 25.99, "Kay Sindre");
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
    public void testGetTitle()
    {
        assertEquals("Test title", book1.getTitle());
    }

    @Test
    public void testGetAuthor()
    {
        assertEquals("Oracle", book1.getAuthor());
    }

    @Test
    public void testGetPrice()
    {
        assertEquals(25.99, book1.getPrice(), 0.1);
    }

    @Test
    public void testSetNewPrice()
    {
        book1.setNewPrice(99.99);
        assertEquals(99.99, book1.getPrice(), 0.1);
    }

    @Test
    public void testGetYearPublished()
    {
        assertEquals(1999, book1.getYearPublished());
    }

    @Test
    public void testGetNumberOfPages()
    {
        assertEquals(42, book1.getNumberOfPages());
    }

    @Test
    public void testGetPublisher()
    {
        assertEquals("Kay Sindre", book1.getPublisher());
    }
}







