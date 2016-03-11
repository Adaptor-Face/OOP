/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class NewsStandTest.
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad
 * @version 2016-03-04
 */
public class NewsStandTest
{
    private NewsStand newsStan1;

    /**
     * Default constructor for test class NewsStandTest
     */
    public NewsStandTest()
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
        newsStan1 = new NewsStand();
        newsStan1.addBookToList("title", "author", 42, 2010, 25.99, "Marvel");
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
    public void testGetList()
    {
        assertEquals("Title: title, Author: author, Price: 25.99,-\n", newsStan1.getList());
    }

    @Test
    public void testAddBookToList()
    {
        newsStan1.addBookToList("Doom", "Kay", 666, 1999, 699.99, "Marvel");
        assertEquals("Title: title, Author: author, Price: 25.99,-\nTitle: Doom, Author: Kay, Price: 699.99,-\n", newsStan1.getList());
    }

    @Test
    public void testRemoveBook()
    {
        assertEquals("Removed title, by author from our listings.", newsStan1.removeBook("title"));
        assertEquals("There are no books to list.", newsStan1.getList());
    }
}
