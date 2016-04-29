
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
 * A dialog used to get the necessary information about a magazine from the
 * user, in order to be able to create a magazine instance to be added
 * to the register.
 *
 * @author asty, Editetd 22.04.16 by Kristoffer Rogne, Kay Sindre Lorgen, Asbjørn Frostad
 */
public class MagazineDetailsDialog extends Dialog<Magazine>
{

    /**
     * Creates an instance of the MagazineDetails dialog
     */
    public MagazineDetailsDialog()
    {
        super();
        setTitle("Magazine Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");

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

        TextField issueNrTxt = new TextField();
        issueNrTxt.setPromptText("Number of pages");

        // Prevent characters (non-integers) to be added
        issueNrTxt.textProperty().addListener(new ChangeListener<String>()
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
                    issueNrTxt.setText(oldValue);
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
        TextField datePublished = new TextField();
        datePublished.setPromptText("Date Published");

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Number of pages:"), 0, 2);
        grid.add(numberOfPagesTxt, 1, 2);
        grid.add(new Label("Price:"), 0, 3);
        grid.add(priceTxt, 1, 3);
        grid.add(new Label("Issue number:"), 0, 4);
        grid.add(issueNrTxt, 1, 4);
        grid.add(new Label("Date Published:"), 0, 5);
        grid.add(datePublished, 1, 5);

        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, Magazine>()
        {
            @Override
            public Magazine call(ButtonType button)
            {
                if (button == ButtonType.OK)
                { try {
                    int numberOfPages = Integer.parseInt(numberOfPagesTxt.getText());
                    double price = Double.parseDouble(priceTxt.getText());
                    int issueNr = Integer.parseInt(issueNrTxt.getText());
                    return new Magazine(title.getText(), price, publisher.getText(), numberOfPages, issueNr, datePublished.getText());
                } catch (NumberFormatException e )
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Empty fields");
                    alert.setHeaderText("Fields can not be empty.");
                    alert.showAndWait();
                }
                }
                return null;
            }
        });
    }
    /**
     * Creates an instance of the MagazineDetails dialog
     */
    public MagazineDetailsDialog(Magazine magazine)
    {
        super();
        setTitle("Magazine Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setText(magazine.getTitle());
        title.setDisable(true);

        TextField publisher = new TextField();
        publisher.setText(magazine.getPublisher());
        publisher.setDisable(true);

        TextField numberOfPagesTxt = new TextField();
        numberOfPagesTxt.setText("" + magazine.getNumberOfPages());
        numberOfPagesTxt.setDisable(true);
        
        TextField issueNrTxt = new TextField();
        issueNrTxt.setText("" + magazine.getIssue());
        issueNrTxt.setDisable(true);

        TextField priceTxt = new TextField();
        priceTxt.setText("" + magazine.getPrice());
        priceTxt.setDisable(true);
        
        TextField datePublished = new TextField();

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Number of pages:"), 0, 2);
        grid.add(numberOfPagesTxt, 1, 2);
        grid.add(new Label("Price:"), 0, 3);
        grid.add(priceTxt, 1, 3);
        grid.add(new Label("Issue number:"), 0, 4);
        grid.add(issueNrTxt, 1, 4);
        grid.add(new Label("Date Published:"), 0, 5);
        grid.add(datePublished, 1, 5);

        getDialogPane().setContent(grid);
    }
}
