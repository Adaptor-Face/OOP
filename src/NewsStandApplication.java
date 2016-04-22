import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
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

/**
 * Demonstrates the use of menus in JavaFX.
 */
public class NewsStandApplication extends Application {

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
        Scene scene = new Scene(root, 300, 250);
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

        // The File-menu
        Menu menuFile = new Menu("App");
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("Print");
        MenuItem exitApp = new MenuItem("Exit");
        menuFile.getItems().addAll(openFile, printFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);
        
         
        exitApp.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                doExitApplication();
            }
        });

        // Add event handler
        openFile.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Open file was selected...");
            }
        });

        Menu menuEdit = new Menu("Edit");

        // The Help-menu
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                doShowAboutDialog();
            }
        });
        menuHelp.getItems().add(about);
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

        return menuBar;
    }

    /**
     * Creates the content of the centre section of the GUI.
     *
     * @return the node to be placed in the centre of the BorderPane
     */
    private Node createCentreContent() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        return grid;
    }
    
    /**
     * Exit the application. Displays a confirmation dialog.
     */
    private void doExitApplication()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Exit Application ?");
        alert.setContentText("Are you sure you want to exit this application?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK)
        {
            // ... user chose OK
            Platform.exit();
        } else
        {
            // ... user chose CANCEL or closed the dialog
            // then do nothing.
        }
   }

    private ToolBar createToolBar() {
        ToolBar toolBar = new ToolBar();
        Button addLiteratureBtn = new Button();
        Button removeLiteratureBtn = new Button();
        Button addNewsPaperBtn = new Button();
        
        
        addLiteratureBtn.setGraphic(new ImageView("images/FolderOpen_32.png"));
        addLiteratureBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                doAddLiterature();
            }

        });
        removeLiteratureBtn.setGraphic(new ImageView("images/Print_32.png"));
        
        toolBar.getItems().addAll(addLiteratureBtn, removeLiteratureBtn, addNewsPaperBtn);
        return toolBar;
    }

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
        if (result.get() == addBookBtn)
        {
            doAddBook();
        } else if (result.get() == addMagazineBtn)
        {
            doAddMagazine();
        } else if (result.get() == addNewsPaperBtn)
        {
            doAddNewsPaper();
        } 
    }

    private void doAddBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doAddMagazine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doAddNewsPaper() {
        NewspaperDetailsDialog npDialog = new NewspaperDetailsDialog();

        Optional<Newspaper> result = npDialog.showAndWait();

        if (result.isPresent())
        {
            NewsPaper newspaper = result.get();
            litReg.addLiterature(newspaper);
            updateObservableList();
            System.out.println("Number of items in litReg: " + litReg.getSize());
        }

    /**
     * Displays an example of an alert (info) dialog. In this case an "about"
     * type of dialog.
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
}
    
   
    
    
