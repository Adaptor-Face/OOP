
import java.util.Scanner;

/**
 * Handles all input from the user
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */

public class InputHandler {
    
    /**
     * 
     */
    public InputHandler()
    {
    }
    
    /**
     * Add literature of the given type and returns it.
     * @return the literature of the given type
     */
    public Literature addLiterature()
    {
    Scanner reader = new Scanner(System.in);
        String literatureType = reader.nextLine();
        Literature literatureToReturn = null;
        if(literatureType.toLowerCase().equals("book"))
        {
            literatureToReturn = addBook();
        }
        if(literatureType.toLowerCase().equals("magazine"))
        {
            literatureToReturn = addMagazine();
        }
        if(literatureType.toLowerCase().equals("newspaper"))
        {
            literatureToReturn = addNewsPaper();
        }
        return literatureToReturn;
    }
    /**
     * Creates a new book and returns it
     * @return the new book created
     */
    private Book addBook()
    {
    Scanner reader = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the title of the book:");
        String title = reader.nextLine();

        System.out.println();
        System.out.println("Enter author of the book:");
        String author = reader.nextLine();

        System.out.println();
        System.out.println("Enter number of pages in the book:");
        int pages = reader.nextInt();
        while(pages < 0)
        {
            System.out.println("ERROR: Number of pages can not be negative!" 
            + "\nEnter correct number of pages");
            pages = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter year the book was published:");
        int year = reader.nextInt();
        while(year < 0)
        {
            System.out.println("ERROR: Year can not be negative!" 
            + "\nEnter correct year");
            year = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter price of the book");
        double price = reader.nextDouble();
        while(price < 0)
        {
            System.out.println("ERROR: Price can not be negative!" 
            + "\nEnter correct price");
            price = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter publisher of the book");
        reader.nextLine();
        String publisher = reader.nextLine();

        System.out.println();
        Book bookToAdd = new Book(title, author, pages, year, price, publisher);
        return bookToAdd;
    }
    
    /**
     * Create a new magazine and returns it
     * @return the new magazine created
     */
    private Magazine addMagazine()
    {
    Scanner reader = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the title of the magazine:");
        String title = reader.nextLine();

        System.out.println();
        System.out.println("Enter number of pages in the magazine:");
        int pages = reader.nextInt();
        while(pages < 0)
        {
            System.out.println("ERROR: Number of pages can not be negative!" 
            + "\nEnter correct number of pages");
            pages = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter issue number of the magazine:");
        int issue = reader.nextInt();
        while(issue < 0)
        {
            System.out.println("ERROR: Year can not be negative!" 
            + "\nEnter correct year");
            issue = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter price of the magazine");
        double price = reader.nextDouble();
        while(price < 0)
        {
            System.out.println("ERROR: Price can not be negative!" 
            + "\nEnter correct price");
            price = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter publisher of the magazine");
        reader.nextLine();
        String publisher = reader.nextLine();

        System.out.println();
        System.out.println("Enter the date the magazine was released:");
        String datePublished = reader.nextLine();

        System.out.println();
        Magazine magazineToAdd = new Magazine(title, price, publisher, pages, issue, datePublished);
        return magazineToAdd;
    }

    /**
     * Create a new newspaper and returns it
     * @return the new newspaper created
     */
    private NewsPaper addNewsPaper() 
    {
    Scanner reader = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the title of the newspaper:");
        String title = reader.nextLine();
        
        System.out.println();
        System.out.println("Enter number of pages in the newspaper:");
        int pages = reader.nextInt();
        while(pages < 0)
        {
            System.out.println("ERROR: Number of pages can not be negative!" 
            + "\nEnter correct number of pages");
            pages = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter publish date of the newspaper was published:");
        String date = reader.nextLine();

        System.out.println();
        System.out.println("Enter price of the newspaper");
        double price = reader.nextDouble();
        while(price < 0)
        {
            System.out.println("ERROR: Price can not be negative!" 
            + "\nEnter correct price");
            price = reader.nextInt();
        }

        System.out.println();
        System.out.println("Enter publisher of the newspaper");
        reader.nextLine();
        String publisher = reader.nextLine();

        System.out.println();
        NewsPaper newsPaperToAdd = new NewsPaper(title, price, publisher, pages, date);
        return newsPaperToAdd;
    }
    
    /**
     * Remove literature of the given type and returns it
     * @param newsStand The newsStand
     * @return the literature of the given type
     */
    public Literature remove(NewsStand newsStand)
    {
    Scanner reader = new Scanner(System.in);
        return newsStand.removeLiterature(reader.nextLine());
    }
    
    /**
     * Check if the user really want to remove the given literature
     * @return true or false 
     */
    public boolean makeCertain()
    {
    Scanner reader = new Scanner(System.in);
              String answer = reader.nextLine();
        if (answer.toLowerCase().equals("yes"))
        {
            return true;
        } else
        {
            return false;
        }
    }
    
    /**
     * Search literature by given title and returns it
     * @param newsStand The newsStand
     * @return the literature by given title 
     */
    public Literature searchByTitle(NewsStand newsStand)
    {
    Scanner reader = new Scanner(System.in);
        return newsStand.searchLiteratureByTitle(reader.nextLine());
    }
}
