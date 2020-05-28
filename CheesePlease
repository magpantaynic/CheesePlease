import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import java.util.ArrayList;
import javafx.event.*;
public class CheesePlease extends Application
{
	public static void main(String[] args)
	{
    	try
    	{
        	launch(args);
    	}
    	catch (Exception error)
    	{
        	error.printStackTrace();
    	}
    	finally
    	{
        	System.exit(0);
    	}
	}
	int score;
	public void start(Stage mainStage)
	{
    	mainStage.setTitle("Cheese Please");
    	BorderPane root = new BorderPane();
    	Scene mainScene = new Scene(root);
    	mainStage.setScene(mainScene);
    	//create the menu interface
    	MenuBar bar = new MenuBar();
    	root.setTop(bar);
    	Menu File = new Menu("File");
    	bar.getMenus().add(File);
    	MenuItem restart = new MenuItem("Restart");
    	MenuItem instruct = new MenuItem("Instructions");
    	File.getItems().addAll(restart, instruct);
    	Canvas canvas = new Canvas(800,600);
    	GraphicsContext context = canvas.getGraphicsContext2D();
    	root.setCenter(canvas);
    	// handle continuous inputs (as long as key is pressed)
    	ArrayList<String> keyPressedList = new ArrayList<String>();
    	// handle discrete inputs (once per key press)
    	ArrayList<String> keyJustPressedList = new ArrayList<String>();
    	mainScene.setOnKeyPressed(
        	(KeyEvent event) ->
        	{
            	String keyName = event.getCode().toString();
            	// avoid adding duplicates to lists
            	if ( !keyPressedList.contains(keyName) )
            	{
                	keyPressedList.add(keyName);
                	keyJustPressedList.add(keyName);
            	}
        	}
    	);
    	mainScene.setOnKeyReleased(
        	(KeyEvent event) ->
        	{
            	String keyName = event.getCode().toString();
            	if ( keyPressedList.contains(keyName) )
                	keyPressedList.remove(keyName);
        	}
    	);
    	Sprite background = new Sprite("images/tiles.png");
    	background.position.set(400,300);
    	restart.setOnAction((ActionEvent e) ->
        	{
            	Sprite mouse = new Sprite("images/mouse.png");
            	mouse.position.set(100,300);
            	Sprite kitten = new Sprite("images/kitten.png");
            	kitten.position.set(0,600);
            	ArrayList<Sprite> cheeseList = new ArrayList<Sprite>();
            	ArrayList<Sprite> mouseList = new ArrayList<Sprite>();
            	mouseList.add(mouse);
            	int cheeseCount = 6;
            	for (int n = 0; n < cheeseCount; n++)
            	{
                	Sprite cheese = new Sprite("images/cheese.png");
                	double x = 700 * Math.random() + 300;
                	double y = 500 * Math.random() + 100;
                	cheese.position.set(x,y);
                	cheeseList.add(cheese);
            	}
            	AnimationTimer gameloop = new AnimationTimer()
                	{
                    	public void handle(long nanotime)
                    	{
                        	boolean dead;
                        	dead= false;
                        	// process user input
                        	if ( keyPressedList.contains("LEFT") && !dead)
                            	mouse.rotation -= 3;
                        	if ( keyPressedList.contains("RIGHT") && !dead)
                            	mouse.rotation += 3;
                        	if ( keyPressedList.contains("UP") && !dead)
                        	{
                            	mouse.velocity.setLength(150);
                            	mouse.velocity.setAngle(mouse.rotation );
                        	}
                        	else // not pressing up
                        	{
                            	mouse.velocity.setLength(0);
                        	}
                        	// after processing user input, clear justPressedList
                        	keyJustPressedList.clear();
                        	//kittens movements
                        	double angle = 340;
                        	kitten.velocity.setLength(150);
                        	kitten.velocity.setAngle(angle);
                        	kitten.wrap(800,600);
                        	//collisions check
                        	for (int s = 0; s < cheeseList.size(); s++)
                        	{
                            	Sprite cheese = cheeseList.get(s);
                            	if ( mouse.overlaps(cheese) && !dead)                    	
                                	cheeseList.remove(cheese);                    	
                        	}  
                        	String text ="";
                        	String loseText = "Alive";
                        	mouse.update(1/60.0);
                        	//bound the mouse to the screen
                        	mouse.boundToScreen(800,600);
                        	//bound to the screen for cheese
                        	for (Sprite cheese : cheeseList)
                        	{
                            	cheese.boundToScreen(800,600);
                            	cheese.update(1/60.0);                	
                        	}
                        	background.render(context);
                        	mouse.render(context);
                        	kitten.update(1/60.0);
                        	kitten.render(context);
                        	for (Sprite cheese : cheeseList)
                            	cheese.render(context);
                        	// draw score on screen
                        	score = cheeseList.size();
                        	context.setFill(Color.WHITE);
                        	context.setStroke(Color.GREEN);
                        	context.setFont( new Font("Arial Black", 48) );
                        	context.setLineWidth(3);
                        	if(cheeseList.size() > 0 && !dead)
                            	text = "cheese left: " + score;
                        	else
                        	{
                            	text = "you win!";
                        	}
                        	int textX = 300;
                        	int textY = 50;
                        	context.fillText(text, textX, textY);
                        	context.strokeText(text, textX, textY);
                        	if(kitten.overlaps(mouse))
                        	{
                            	loseText = "You Lose!";
                            	stop();
                        	}
                        	int losetextX = 50;
                        	int losetextY = 50;
                        	context.fillText(loseText, losetextX, losetextY);
                        	context.strokeText(loseText, losetextX, losetextY);
                        	if(cheeseList.size() ==0)
                            	stop();
                    	}
                	};
            	gameloop.start();
        	}
    	);	
    	
    	instruct.setOnAction((ActionEvent e) ->
    	{
        	Alert info = new Alert(AlertType.INFORMATION);
            	info.setTitle("ERROR");
            	info.setHeaderText(null);
            	info.setContentText("the left and right arrow keys are to move while"
            	+ "the up arrow key helps move forward use this to collect cheese and avoid the cat");
            	
            	info.showAndWait();
        	
        	}
        	);
    	mainStage.show();
	}
}
