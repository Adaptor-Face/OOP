
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.util.Callback;

/**
 * Demonstrates the use of menus in JavaFX.
 */
public class NewsStandApplication extends Application {

    /**
     * Register containing the Literature. This reg is non-JavaFX-specific.
     */
    private LiteratureRegister literatureList;
    private TableView tableView;
    /**
     * An ObservableList used to "wrap" the real register to enable the link
     * between the TableView and the LiteratureRegister.
     */
    private ObservableList<Literature> literatures;

    @Override
    public void init() {
        literatureList = new LiteratureRegister();
    }

    /**
     * The start-method is called by the JavaFX platform upon starting the
     * JavaFX-platform. The method is abstract and must be overridden by any
     * subclass of Application. The main window is setup in this method,
     * including menus, toolboxes etc.
     *
     * @param primaryStage The main stage making up the main window.
     */
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane(); // Create the root node. The Menu will be placed at the top
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu = createMenus();  //Creates our main menu to hold our Sub-Menus.
        ToolBar toolBar = createToolBar();  // Creates a toolbare below the menubar

        // Place the menubar in the topContainer
        topContainer.getChildren().add(mainMenu);
        // Place the Toolbar
        topContainer.getChildren().add(toolBar);

        // Place the topcontainer in the top-section of the BorderPane
        root.setTop(topContainer);
        // Place the centre content
        root.setCenter(createCentreContent());

        // Create the scene, adding the rootNode and setting the size
        Scene scene = new Scene(root, 475, 300);
        // Set title of the stage (window) and add the scene
        primaryStage.setTitle("Literaturemaster 4000");
        primaryStage.setScene(scene);
        // Finally, make the stage (window) visible
        primaryStage.show();
    }

    /**
     * The stop() method is being called by the JavaFX-platform when the
     * platform stops, are being terminated. This would typically happen as a
     * result of the last open window being closed. Override this method to make
     * sure that the application is terminated.
     */
    @Override
    public void stop() {
        System.exit(0);

    }

    /**
     * The entry-point to start the application.
     *
     * @param args Command-line arguments supplied during startup
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates and returns the menus to be displayed.
     *
     * @return The MenuBar to be displayed.
     */
    private MenuBar createMenus() {
        // Create the Menu Bar to hold all the menus
        MenuBar menuBar = new MenuBar();

        // The App-menu
        Menu menuFile = new Menu("App");
        MenuItem selectedDetails = new MenuItem("Details");
        MenuItem exitApp = new MenuItem("Exit");
        menuFile.getItems().addAll(selectedDetails, new SeparatorMenuItem(), exitApp);

        exitApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doExitApplication();
            }
        });

        selectedDetails.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doShowDetails();
            }
        });
        // The Edit-menu
        Menu menuEdit = new Menu("Edit");
        MenuItem addLiterature = new MenuItem("Add");
        MenuItem removeLiterature = new MenuItem("Remove");
        menuEdit.getItems().addAll(addLiterature, removeLiterature);

        addLiterature.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doAddLiterature();
            }
        });

        removeLiterature.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doRemoveLiterature();
            }
        });
        // The Help-menu
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doShowAboutDialog();
            }
        });
        MenuItem fillRegister = new MenuItem("Fill register");
        fillRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doFillRegister();
            }
        });
        menuHelp.getItems().add(about);
        menuHelp.getItems().add(fillRegister);
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

        return menuBar;
    }

    /**
     * Creates the content of the centre section of the GUI.
     *
     * @return the node to be placed in the centre of the BorderPane
     */
    private Node createCentreContent() {
        VBox vbox = new VBox();

        // Define the columns
        // The Title-column
        TableColumn<Literature, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // The Publisher-column
        TableColumn<Literature, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(200);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        // The Type-column
        TableColumn<Literature, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(75);
        typeColumn.setCellValueFactory(new Callback<CellDataFeatures<Literature, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Literature, String> p) {
                return new ReadOnlyStringWrapper(p.getValue().getClass().getSimpleName());
            }
        });
        tableView = new TableView();
        tableView.setItems(this.getLiteratureList());
        tableView.getColumns().addAll(titleColumn, publisherColumn, typeColumn);
        vbox.getChildren().add(tableView);
        return vbox;
    }

    /**
     * Returns an ObservableList holding the literatures to display.
     *
     * @return an ObservableList holding the literatures to display.
     */
    private ObservableList<Literature> getLiteratureList() {
        // Create an ObservableArrayList wrapping the LiteratureRegister
        literatures
                = FXCollections.observableArrayList(this.literatureList.listAllLiteratures());
        return literatures;
    }

    /**
     * Exit the application. Displays a confirmation dialog.
     */
    private void doExitApplication() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Exit Application ?");
        alert.setContentText("Are you sure you want to exit this application?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            Platform.exit();
        } else {
            // ... user chose CANCEL or closed the dialog
            // then do nothing.
        }
    }

    /**
     * Creates the content of the toolbar section of the GUI.
     *
     * @return the node to be placed in the toolbar of the BorderPane
     */
    private ToolBar createToolBar() {
        ToolBar toolBar = new ToolBar();
        Button addLiteratureBtn = new Button();
        Button removeLiteratureBtn = new Button();
        Button showDetailsBtn = new Button();

        TextField search = new TextField();
        search.setPromptText("Search");
        // Prevent characters (non-integers) to be added
        search.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                doFindMatchingLiterature(newValue);
            }
        });
        Button clearSearchBtn = new Button();
        clearSearchBtn.visibleProperty().bind(search.textProperty().isEmpty().not());

        clearSearchBtn.setBorder(Border.EMPTY);
        clearSearchBtn.setBackground(Background.EMPTY);
        clearSearchBtn.setPadding(Insets.EMPTY);
        clearSearchBtn.setGraphic(new ImageView("images/clear_10.png"));
        clearSearchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                search.clear();
            }
        });

        addLiteratureBtn.setGraphic(new ImageView("images/plus_32.png"));
        addLiteratureBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doAddLiterature();
            }

        });
        showDetailsBtn.setGraphic(new ImageView("images/information_32.png"));
        showDetailsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doShowDetails();
            }

        });
        removeLiteratureBtn.setGraphic(new ImageView("images/minus_32.png"));

        removeLiteratureBtn.setOnAction(e -> doRemoveLiterature());
        toolBar.getItems().addAll(addLiteratureBtn, removeLiteratureBtn, showDetailsBtn, search, clearSearchBtn);
        return toolBar;
    }

    /**
     * Adds literature to the listings.
     */
    private void doAddLiterature() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Add Literature");
        alert.setHeaderText("What type of literature to add?");

        ButtonType addBookBtn = new ButtonType("Book");
        ButtonType addMagazineBtn = new ButtonType("Magazine");
        ButtonType addNewsPaperBtn = new ButtonType("NewsPaper");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(addBookBtn, addMagazineBtn, addNewsPaperBtn, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == addBookBtn) {
            doAddBook();
        } else if (result.get() == addMagazineBtn) {
            doAddMagazine();
        } else if (result.get() == addNewsPaperBtn) {
            doAddNewsPaper();
        }
        updateObservableList();
    }

    /**
     * Adds a book to the listings.
     */
    private void doAddBook() {
        BookDetailsDialog npDialog = new BookDetailsDialog();

        Optional<Book> result = npDialog.showAndWait();

        if (result.isPresent()) {
            Book book = result.get();
            if (book.equals(literatureList.findLiterature(book.getTitle()))) {
            
            } else {
            literatureList.add(book);
            }
        }
    }

    /**
     * Adds a magazine to the listings.
     */
    private void doAddMagazine() {
        MagazineDetailsDialog npDialog = new MagazineDetailsDialog();

        Optional<Magazine> result = npDialog.showAndWait();

        if (result.isPresent()) {
            Magazine magazine = result.get();
            if (magazine.equals(literatureList.findLiterature(magazine.getTitle()))) {
            
            } else {
            literatureList.add(magazine);
            }
        }
    }

    /**
     * Adds a newspaper to the listings.
     */
    private void doAddNewsPaper() {
        NewspaperDetailsDialog npDialog = new NewspaperDetailsDialog();

        Optional<NewsPaper> result = npDialog.showAndWait();

        if (result.isPresent()) {
            NewsPaper newspaper = result.get();
            if (newspaper.equals(literatureList.findLiterature(newspaper.getTitle()))) {
            
            } else {
            literatureList.add(newspaper);
            }
        }
    }
    
    /**
     * Shows an alert.
     */
    private void doShowAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Literature already registered!");
        alert.showAndWait();
        
    }

    /**
     * Updates the ObservableArray wrapper with the current content in the
     * Literature register. Call this method whenever changes are made to the
     * underlying LiteratureRegister.
     */
    private void updateObservableList() {
        this.literatures.setAll(this.literatureList.listAllLiteratures());
    }

    /**
     * Displays an alert (info) dialog which show information about the creators
     * of Literaturemaster 4000.
     */
    private void doShowAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Literaturemaster 4000");
        alert.setHeaderText("Literaturemaster 4000");
        alert.setContentText("Application created by\n"
                + "(C)Kristoffer Rogne, Asbjørn Frostad & Kay Sindre Lorgen\n"
                + "v0.4000");

        alert.showAndWait();
    }

    /**
     * Fill register with dummy books.
     */
    private void doFillRegister() {
        literatureList.add(new Book("Java book", "Kay", 165, 1985, 199, "Lorgen inc"));
        literatureList.add(new Book("This book", "Asbjørn", 777, 1999, 299, "Frostad inc"));
        literatureList.add(new Book("Book of life", "Kristoffer", 666, 2015, 499, "Rogne inc"));
        literatureList.add(new NewsPaper("News paper", 10, "Lorgen newspaper inc", 48, "24.04.2016"));
        literatureList.add(new Magazine("Cool magazine", 69, "Lorgen magazine inc", 124, 7, "24.04.2016"));
        updateObservableList();
    }

    /**
     * Remove literature from the listnings.
     */
    private void doRemoveLiterature() {
        Object tempObj = tableView.getSelectionModel().getSelectedItem();
        if (tempObj != null) {
            if (tempObj instanceof Literature) {
                Literature literatureToRemove = (Literature) tempObj;
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Remove");
                alert.setHeaderText("Are you sure you want to remove " + literatureToRemove.getTitle() + "?");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    literatureList.remove(literatureToRemove.getTitle());
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Remove");
                    alert.setHeaderText(literatureToRemove.getTitle() + " has been deleted!");
                    alert.showAndWait();
                } else {

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Remove");
                    alert.setHeaderText(literatureToRemove.getTitle() + " was not removed");
                    alert.showAndWait();
                }
                updateObservableList();
            }

        }
    }

    /**
     * Search for literature by title.
     * @param title The title of the literature u want to find.
     */
    private void doFindMatchingLiterature(String title) {
        LiteratureRegister matchingLiterature = new LiteratureRegister();
        for (Literature literature : literatureList.listAllLiteratures()) {
            if (literature.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingLiterature.add(literature);
            }
        }
        literatures.setAll(matchingLiterature.listAllLiteratures());
    }

    /**
     * Displays the details of a literature.
     */
    private void doShowDetails() {
        Object tempObj = tableView.getSelectionModel().getSelectedItem();
        if (tempObj instanceof Book) {
            BookDetailsDialog bdDialog = new BookDetailsDialog((Book) tempObj);
            bdDialog.showAndWait();
        } else if (tempObj instanceof Magazine) {
            MagazineDetailsDialog mdDialog = new MagazineDetailsDialog((Magazine) tempObj);
            mdDialog.showAndWait();
        } else if (tempObj instanceof NewsPaper) {
            NewspaperDetailsDialog ndDialog = new NewspaperDetailsDialog((NewsPaper) tempObj);
            ndDialog.showAndWait();
        }

    }
}
