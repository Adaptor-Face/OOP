import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
/**
 * Holds the list of books.
 * You are able to print out the list alphabeticaly or by price
 * You can search for books by  author name, surname and/or last name,
 * by book title, partial title allowed, and by publisher.
 * Generic search searches within author, title and publisher. 
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.2, 2016-03-04
 */
public class LiteratureRegister
{
    private ArrayList<Book> bookList;
    /**
     * Creates a list of the current books that re being sold.
     */
    public LiteratureRegister()
    {
        bookList = new ArrayList<Book>();
    }

    /**
     * Adds a new book to the register.
     * @param bookToAdd The book you want to add to the register.
     */
    public void addNewBook(Book bookToAdd)
    {
        bookList.add(bookToAdd);
    }
    /*
    /**
     * Prints out a list containing all books, complete with author name, title and price.

    public void listAllBooks()
    {
    System.out.println();
    if (bookList.size() <= 0)
    {
    System.out.println("There is no books.");
    }
    for(Book book : bookList)
    {
    System.out.println("Title: " + book.getTitle() + ", Author: " 
    + book.getAuthor() + ". Price: " + book.getPrice() + ",-");
    }
    }
     */
    /**
     * Prints out the list of books, from cheapest to most expensive.
     */
    public String listAllBooksByPrice()
    {
        String a = null;
        if (bookList.size() <= 0)
        {
            a = "There is no books.";
        }
        ArrayList<Double> bookPriceList = new ArrayList<Double>();
        for(Book book : bookList)
        {
            bookPriceList.add(book.getPrice());
        }
        Collections.sort(bookPriceList);
        for(double price : bookPriceList)
        {
            for(Book book: bookList)
            {
                if(price == book.getPrice())
                {
                    a = "Title: " + book.getTitle() + ", Author: " 
                    + book.getAuthor() + ". Price: " + book.getPrice() + ",-";
                }
            }
        }
        return a;
    }

    //     /**
    //      * Prints out the list of books, alphabeticaly.
    //      */
    //     public void listAllBooks()
    //     {
    //         System.out.println();
    //         if (bookList.size() <= 0)
    //         {
    //             System.out.println("There is no books.");
    //         }
    //         ArrayList<String> sortedBookList = new ArrayList<String>();
    //         for(Book book : bookList)
    //         {
    //             sortedBookList.add(book.getTitle());
    //         }
    //         Collections.sort(sortedBookList);
    //         for(String title : sortedBookList)
    //         {
    //             for(Book book: bookList)
    //             {
    //                 if(title.equals(book.getTitle()))
    //                 {
    //                     System.out.println("Title: " + book.getTitle() + ", Author: " 
    //                         + book.getAuthor() + ". Price: " + book.getPrice() + ",-");
    //                 }
    //             }
    //         }
    //     }

    /**
     * Returns the list of books.
     * @return the list of books.
     */
    public ArrayList<Book> listAllBooks()
    {
        ArrayList<Book> listToReturn = new ArrayList<Book>();
        for(Book book : bookList)
        {
           listToReturn.add(book);
        }
        return listToReturn;
    }

        /**
     * Searches for the book by title.
     * @param title The title of the book you want. 
     */

    public String searchByTitle(String title)
    {
        String bookTitle = ("Matching books with the title " + title + ":");
        Boolean found = false;
        for(Book book : bookList)
        {
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                bookTitle += (" Title: " + book.getTitle() + ", Author: " 
                    + book.getAuthor() + ", Price: " + book.getPrice() + ",-");
                found = true;
            }
        }
        if (!found)
        {
            bookTitle += ("No books found searching for " + title + ".");
        }

        return bookTitle;
    }

    /**
     * Searches for the author name.
     * @param authorName The name of the author you want. 
     */

    public String searchAuthor(String authorName)
    {

        String a = ("Matching books from author " + authorName + ":");
        Boolean found = false;
        for(Book book : bookList)
        {
            if(book.getAuthor().toLowerCase().contains(authorName.toLowerCase()))
            {
                a += ("Title: " + book.getTitle() + ", Author: " 
                    + book.getAuthor() + ". Price: " + book.getPrice() + ",-");
                found = true;
            }
        }
        if (!found)
        {
            a += ("No books found searching for " + authorName + ".");
        }

        return a;
    }

    /**
     * Searches for the publisher.
     * @param publisher The name of the publisher you want.
     */
    public String searchPublisher(String publisher)
    {
        String a = ("Matching books from publisher " + publisher + ":");
        Boolean found = false;
        for(Book book : bookList)
        {
            if(book.getPublisher().toLowerCase().contains(publisher.toLowerCase()))
            {
                a += ("Title: " + book.getTitle() + ", Author: " 
                    + book.getAuthor() + ". Price: " + book.getPrice() + ",-");
                found = true;
            }
        }
        if (!found)
        {
            a += ("No books found searching for " + publisher + ".");
        }

        return a;
    }

    /**
     * Generic search for books with title, publisher or author
     * matching search word.
     * @param search The word to search for.
     */
    public String genericSearch(String search)
    {
        String a = ("Matching books searching for " + search + ":");
        Boolean found = false;
        for(Book book : bookList)
        {
            if(book.getPublisher().toLowerCase().contains(search.toLowerCase()) || book.getTitle().toLowerCase().contains(search.toLowerCase())
            || book.getAuthor().toLowerCase().contains(search.toLowerCase()))
            {
                a += ("Title: " + book.getTitle() + ", Author: " 
                    + book.getAuthor() + ". Price: " + book.getPrice() + ",-");
                found = true;
            }
        }
        if (!found)
        {
            a += ("No books found searching for " + search + ".");
        }

        return a;
    }

    /**
     * Removes the book from the list.
     * @param bookTitle The title of the book you want to remove.
     */
    public String removeBookFromList(String bookTitle)
    {
        String removedBookTitle = null;
        Boolean removed = false;
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext())
        {
            Book bookToRemove = it.next();
            if(bookToRemove.getTitle().equals(bookTitle))
            {
                removedBookTitle = ("Removed " + bookToRemove.getTitle() + ", by " 
                    + bookToRemove.getAuthor() + " from our listings.");
                removed = true;
                it.remove();
            }
        }
        if(!removed)
        {
            removedBookTitle = ("There was no book with the title of " + bookTitle);
        }

        return removedBookTitle;
    }

}
