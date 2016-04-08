
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Makes up the user interface (text based) of the newsstand.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */
class NewsStandUI {

    private NewsStand newsStand = null;
    InputHandler input;

    /**
     * Creates an instance of the NewsStandUI User interface. An instance
     * of the NewsStand is created, and initialized.
     */
    public NewsStandUI() {
        //TODO: Replace "new Application" with your application class.
        this.newsStand = new NewsStand();
        this.input = new InputHandler();
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
                    searchByTitle();
                    break;

                    case 4:
                    removeLiteratureFromList();
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
    public void removeLiteratureFromList()
    {
        System.out.println("Enter the title of the book you wish to remove");
        Literature literature = input.remove(newsStand);
        if(literature == null)
        {
            System.out.println("There was no literature with that title.");
        } else
        {
            if(input.makeCertain(literature))
            {
                System.out.println(literature.getTitle() + " was removed from the lists.");
            }else
                System.out.println(literature.getTitle() + " was not removed.");
        }
    }
    
    /**
     * Search for a book by title
     */
    public void searchByTitle()
    {
        System.out.println("Enter title to search for:");
        Literature foundLiterature = input.searchByTitle(newsStand);
        if(foundLiterature == null)
        {
            System.out.println("Nothing found with that title");
        }else
        {
            System.out.println("The following literature was found:");
            System.out.println(foundLiterature.getInfo());
        }
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
        System.out.println("Enter the type of literature you want to add."
                + "\nBook, Magazine or NewsPaper");
        newsStand.addLiteratureToList(input.addLiterature());
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
