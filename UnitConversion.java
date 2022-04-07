import javafx.application.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.*;
/**
 * HW16: Unit Conversion
 * Creator: Lee Stemkoski
 * Submitted by: Nicole Magpantay
 *
 * Finish the unit conversion application started in class. 
 */
public class UnitConversion extends Application
{
    public static void main(String[] args)
    {
        try
        {
            launch(args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }
    }
    public void start(Stage mainStage)
    {
        mainStage.setTitle("Unit Converter");
        
        mainStage.getIcons().add(new Image("icons/update.png"));
        BorderPane root = new BorderPane();
        //create our menu interface
        MenuBar menubar = new MenuBar();
        root.setTop(menubar);
        Menu file = new Menu("File");
        menubar.getMenus().add(file);
        //create the items that are going to be in the menu
        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
        MenuItem quit = new MenuItem("Quit");
        file.getItems().addAll(help,about,quit);
        VBox centerBox = new VBox();
        centerBox.setPadding( new Insets(16) );
        centerBox.setSpacing(8);
        root.setCenter(centerBox);
        Scene mainScene = new Scene(root, 600, 600);
        mainStage.setScene(mainScene);
        // the following line loads a stylesheet file; incorrect syntax will generate a parse warning
        mainScene.getStylesheets().add("assets/stylesheet.css");
        // custom code below --------------------------------------------
        GridPane grid = new GridPane();
        grid.setPadding( new Insets(30) );
        grid.setHgap(30);
        grid.setVgap(30);
        TextField cm = new TextField();
        TextField in = new TextField();
        TextField ft = new TextField();
        Label cmLabel = new Label("centimeters");
        Label inchLabel = new Label("inches");
        Label feetLabel = new Label("feet");
        // object, column, row
        grid.add(cm, 0, 0);
        grid.add(cmLabel, 1, 0);
        grid.add(in, 0, 1);
        grid.add(inchLabel, 1, 1);
        grid.add(ft, 0, 2);
        grid.add(feetLabel, 1, 2);
        centerBox.getChildren().add(grid);
        // the math to convert 
        in.setOnAction(
            (ActionEvent event) ->
            {
                try
                {
                    //inches into centimeters or feet
                    Double inches = Double.parseDouble( in.getText() );
                    double centimeters = 2.54 * inches;
                    cm.setText( String.valueOf(centimeters) );
                    double feet = inches / 12;
                    ft.setText( String.valueOf(feet) );
                }
                catch (Exception error)
                {
                    Alert info = new Alert(AlertType.INFORMATION);
                    info.setTitle("ERROR");
                    info.setHeaderText(null);
                    info.setContentText("Enter a number not a letter");
                    info.setGraphic(
                        new ImageView( new Image("icons/undo.png",64,64,true,true)));
                    info.showAndWait();
                }
            }
        );
        cm.setOnAction(
            (ActionEvent event) ->
            {
                try
                {
                    //centimeters into inches or feet
                    Double centimeters = Double.parseDouble( cm.getText() );
                    double inches = centimeters / 2.54 ;
                    in.setText( String.valueOf(inches) );
                    double feet = centimeters / 30.48;
                    ft.setText( String.valueOf(feet) );
                }
                catch (Exception error)
                {
                    Alert info = new Alert(AlertType.INFORMATION);
                    info.setTitle("ERROR");
                    info.setHeaderText(null);
                    info.setContentText("Enter a number not a letter");
                    info.setGraphic(
                        new ImageView( new Image("icons/undo.png",64,64,true,true)));
                    info.showAndWait();
                }
            }
        );
        ft.setOnAction(
            (ActionEvent event) ->
            {
                try
                {
                    //feet into inches or centimeters
                    Double feet = Double.parseDouble( ft.getText() );
                    double inches = feet * 12;
                    in.setText( String.valueOf(inches) );
                    double centimeters = feet * 30.48;
                    cm.setText( String.valueOf(centimeters) );                    
                }
                catch (Exception error)
                {
                    Alert info = new Alert(AlertType.INFORMATION);
                    info.setTitle("ERROR");
                    info.setHeaderText(null);
                    info.setContentText("Enter a number not a letter");
                    info.setGraphic(
                        new ImageView( new Image("icons/undo.png",64,64,true,true)));
                    info.showAndWait();
                }
            }
        );
        //menu Fuctions
        quit.setOnAction((ActionEvent e) ->
            {
                System.exit(0);
            }
        );
        about.setOnAction((ActionEvent e) ->
            {
                Alert info = new Alert(AlertType.INFORMATION);
                info.setTitle("ERROR");
                info.setHeaderText(null);
                info.setContentText("you enter a number in the respected textbox "
                    +" then you would click enter and it converts to the other fields");
                info.setGraphic(
                    new ImageView( new Image("icons/information.png",64,64,true,true)));
                info.showAndWait();
            }
        );
        help.setOnAction((ActionEvent e) ->
            {
                Alert info = new Alert(AlertType.INFORMATION);
                info.setTitle("ERROR");
                info.setHeaderText(null);
                info.setContentText("enter a number in a textbox then press enter");
                info.setGraphic(
                    new ImageView( new Image("icons/help.png",64,64,true,true)));
                info.showAndWait();
            }
        );
        
        //faster way to access menuitems
        about.setAccelerator(
            new KeyCodeCombination( KeyCode.A, KeyCodeCombination.CONTROL_DOWN )
        );
        help.setAccelerator(
            new KeyCodeCombination( KeyCode.H, KeyCodeCombination.CONTROL_DOWN )
        );
        quit.setAccelerator(
            new KeyCodeCombination( KeyCode.Q, KeyCodeCombination.CONTROL_DOWN )
        );
        // custom code above --------------------------------------------
        mainStage.show();
    }

}
