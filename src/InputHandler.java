
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
    public Literature addBook()
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
    
    public void remove()
    {
    Scanner reader = new Scanner(System.in);
        System.out.println("Enter the titel of the book you wish to remove");
        System.out.println(newsStand.removeLiterature(reader.nextLine()));
    }
}
