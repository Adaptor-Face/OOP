
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * A dialog used to get the necessary information about a book from the
 * user, in order to be able to create a book instance to be added
 * to the register.
 *
 * @author asty, Edited 22.04.16 by Kristoffer Rogne, Kay Sindre Lorgen, Asbjørn Frostad
 */
public class BookDetailsDialog extends Dialog<Book>
{

    /**
     * Creates an instance of the BookDetails dialog
     */
    public BookDetailsDialog()
    {
        super();
        setTitle("Enter Book Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");
        
        TextField author = new TextField();
        author.setPromptText("Author");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField numberOfPagesTxt = new TextField();
        numberOfPagesTxt.setPromptText("Number of pages");

        // Prevent characters (non-integers) to be added
        numberOfPagesTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    numberOfPagesTxt.setText(oldValue);
                }
            }
        });

        TextField yearPublishedTxt = new TextField();
        yearPublishedTxt.setPromptText("Number of pages");

        // Prevent characters (non-integers) to be added
        yearPublishedTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    yearPublishedTxt.setText(oldValue);
                }
            }
        });

        TextField priceTxt = new TextField();
        priceTxt.setPromptText("Price");
        // Prevent characters (non-integers) to be added
        priceTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Double.parseDouble(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    priceTxt.setText(oldValue);
                }
            }
        });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Author:"), 0, 1);
        grid.add(author, 1, 1);
        grid.add(new Label("Publisher:"), 0, 2);
        grid.add(publisher, 1, 2);
        grid.add(new Label("Number of pages:"), 0, 3);
        grid.add(numberOfPagesTxt, 1, 3);
        grid.add(new Label("Price:"), 0, 4);
        grid.add(priceTxt, 1, 4);
        grid.add(new Label("Year Published:"), 0, 5);
        grid.add(yearPublishedTxt, 1, 5);

        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, Book>()
        {
            @Override
            public Book call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {
                    try {
                    int numberOfPages = Integer.parseInt(numberOfPagesTxt.getText());
                    double price = Double.parseDouble(priceTxt.getText());
                    int yearPublished = Integer.parseInt(yearPublishedTxt.getText());
                    
                    if(title.getText().isEmpty() || author.getText().isEmpty() || publisher.getText().isEmpty())
                    {
                                doShowAlert();
                    }else {
                    return new Book(title.getText(), author.getText(), numberOfPages, yearPublished, price, publisher.getText());
                    }
                    } catch (NumberFormatException e)
                    {
                        doShowAlert();
                        
                    }
                }
                return null;
            }
        });
    }
    
    /**
     * Creates an instance of the BookDetails dialog that 
     * displays a books information.
     * @param book the book to display
     */
    public BookDetailsDialog(Book book)
    {
        super();
        setTitle("Book Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setText(book.getTitle());
        title.setDisable(true);
        
        TextField author = new TextField();
        author.setText(book.getAuthor());
        author.setDisable(true);

        TextField publisher = new TextField();
        publisher.setText(book.getPublisher());
        publisher.setDisable(true);

        TextField numberOfPagesTxt = new TextField();
        numberOfPagesTxt.setText("" + book.getNumberOfPages());
        numberOfPagesTxt.setDisable(true);
        
        TextField yearPublishedTxt = new TextField();
        yearPublishedTxt.setText("" + book.getYearPublished());
        yearPublishedTxt.setDisable(true);
        
        TextField priceTxt = new TextField();
        priceTxt.setText("" + book.getPrice());
        priceTxt.setDisable(true);

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Author:"), 0, 1);
        grid.add(author, 1, 1);
        grid.add(new Label("Publisher:"), 0, 2);
        grid.add(publisher, 1, 2);
        grid.add(new Label("Number of pages:"), 0, 3);
        grid.add(numberOfPagesTxt, 1, 3);
        grid.add(new Label("Price:"), 0, 4);
        grid.add(priceTxt, 1, 4);
        grid.add(new Label("Year Published:"), 0, 5);
        grid.add(yearPublishedTxt, 1, 5);

        getDialogPane().setContent(grid);
    }
    private void doShowAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Empty fields");
        alert.setHeaderText("Fields can not be empty.");
        alert.showAndWait();
    }
}
