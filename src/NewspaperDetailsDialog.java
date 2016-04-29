
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * A dialog used to get the necessary information about a newspaper from the
 * user, in order to be able to create a Newspaper instance to be added
 * to the register.
 *
 * @author asty
 */
public class NewspaperDetailsDialog extends Dialog<NewsPaper>
{

    /**
     * Creates an instance of the NewspaperDetails dialog
     */
    public NewspaperDetailsDialog()
    {
        super();
        setTitle("Newspaper Details");

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
        grid.add(new Label("Date Published:"), 0, 4);
        grid.add(datePublished, 1, 4);

        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, NewsPaper>()
        {
            @Override
            public NewsPaper call(ButtonType button)
            {
                if (button == ButtonType.OK)
                { try {
                    int numberOfPages = Integer.parseInt(numberOfPagesTxt.getText());
                    double price = Double.parseDouble(priceTxt.getText());
                        if (title.getText().isEmpty() || datePublished.getText().isEmpty() || publisher.getText().isEmpty()) {
                            doShowAlert();
                        } else {
                    return new NewsPaper(title.getText(), price, publisher.getText(), numberOfPages, datePublished.getText());
                }
                }catch (NumberFormatException e) {
                    doShowAlert();
                }
                }
                return null;
            }

        });
    }

    /**
     * Displays the details of the newspaper.
     * @param newsPaper the newspaper u want to display the details of.
     */
    public NewspaperDetailsDialog(NewsPaper newsPaper)
    {
        super();
        setTitle("Newspaper Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setText(newsPaper.getTitle());
        title.setDisable(true);

        TextField publisher = new TextField();
        publisher.setText(newsPaper.getPublisher());
        publisher.setDisable(true);

        TextField numberOfPagesTxt = new TextField();
        numberOfPagesTxt.setText("" + newsPaper.getNumberOfPages());
        numberOfPagesTxt.setDisable(true);

        TextField priceTxt = new TextField();
        priceTxt.setText("" + newsPaper.getPrice());
        priceTxt.setDisable(true);
        
        TextField datePublished = new TextField();
        datePublished.setText(newsPaper.getDatePublished());
        datePublished.setDisable(true);

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Number of pages:"), 0, 2);
        grid.add(numberOfPagesTxt, 1, 2);
        grid.add(new Label("Price:"), 0, 3);
        grid.add(priceTxt, 1, 3);
        grid.add(new Label("Date Published:"), 0, 4);
        grid.add(datePublished, 1, 4);

        getDialogPane().setContent(grid);
    }
            private void doShowAlert() {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Empty fields");
                    alert.setHeaderText("Fields can not be empty.");
                    alert.showAndWait();
            }
}
