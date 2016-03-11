
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the newsstand.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.1, 2016-03-04
 */
class NewsStandUI {

    private NewsStand newsStand = null;
    Scanner reader = new Scanner(System.in);

    /**
     * Creates an instance of the NewsStandUI User interface. An instance
     * of the NewsStand is created, and initialized.
     */
    public NewsStandUI() {
        //TODO: Replace "new Application" with your application class.
        this.newsStand = new NewsStand();
    }

    /**
     * Starts the NewsStandUI by showing the menu and retrieving input from the
     * user.
     */
    void start() {
        boolean quit = false;
        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                    System.out.println(newsStand.getList());
                    break;

                    case 2:
                    addNewBookToList();
                    break;

                    case 3:
                    searchForBookByTitle();
                    break;

                    case 4:
                    removeBookFromList();
                    break;

                    case 5:
                    System.out.println("\nThank you for using Bookmaster 3000. Bye!\n");
                    quit = true;
                    break;

                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and 5..\n");
            }
        }        

    }
    
    /**
     * Remove a book from register
     */
    public void removeBookFromList()
    {
        System.out.println("Enter the titel of the book you wish to remove");
        System.out.println(newsStand.removeBook(reader.nextLine()));
    }
    
    /**
     * Search for a book by title
     */
    public void searchForBookByTitle()
    {
        System.out.println("Enter the book title you wish to seach for");
        System.out.println(newsStand.searchBookByTitle(reader.nextLine()));
    }

    /**
     * Add a new book to the register.
     * Input is read line by line.
     * first: title of the book.
     * second: author of the book.
     * third: number of pages, only positive int number.
     * forth: year published, only positive int number.
     * fifth: price, only positive double (in NOK).
     * last: the name of the publisher of the book.
     * 
     */
    private void addNewBookToList()
    {
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
        newsStand.addBookToList(title, author, pages, year, price, publisher);
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and 5. If the user inputs anything
     * else, an InputMismatchException is thrown. The method returns the valid
     * input from the user.
     *
     * Returns the menu number provided by the user
     * @return the menu number (between 1 and 5) provided by the user.
     * @throws InputMismatchException
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Bookmaster 3000 ****\n");
        System.out.println("1. List all books");
        System.out.println("2. Add new book");
        System.out.println("3. Find a book by title");
        System.out.println("4. Remove a book by title");
        System.out.println("5. Exit");
        System.out.println("Please choose menu item (1-5): ");

        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > 6)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

}
