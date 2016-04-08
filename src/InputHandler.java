
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kristoffer Rogne
 */
public class InputHandler {
    public InputHandler()
    {
    }
    
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
        System.out.println("Enter year the newspaper was published:");
        int year = reader.nextInt();
        while(year < 0)
        {
            System.out.println("ERROR: Year can not be negative!" 
            + "\nEnter correct year");
            year = reader.nextInt();
        }

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
        NewsPaper newsPaperToAdd = new NewsPaper(title, price, publisher, pages, year);
        return newsPaperToAdd;
    }
    
    public Literature remove(NewsStand newsStand)
    {
    Scanner reader = new Scanner(System.in);
        return newsStand.removeLiterature(reader.nextLine());
    }
    
    public boolean makeCertain(Literature literature)
    {
    Scanner reader = new Scanner(System.in);
        System.out.println("Are you sure you want to remove: \n" + literature.getInfo() + "\nyes or no");
        String answer = reader.nextLine();
        if (answer.toLowerCase().equals("yes"))
        {
            return true;
        } else
        {
            return false;
        }
    }
    
    public Literature searchByTitle(NewsStand newsStand)
    {
    Scanner reader = new Scanner(System.in);
        return newsStand.searchLiteratureByTitle(reader.nextLine());
    }
}
