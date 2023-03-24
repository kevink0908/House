// Name: Kevin Kim
// Course: CS 2450
// Project: In-Class Lab 4
// Date: 3/23/2023
// Description: This program creates a house.

package application;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;

public class Main extends Application
{
	private Line roof1 = new Line(200, 260, 320, 180);
	private Line roof2 = new Line(320, 180, 440, 260);
	private Line doorBottom = new Line(289, 439, 349, 439);
	private Line windowLine1 = new Line(250, 310, 290, 310);
	private Line windowLine2 = new Line(270, 290, 270, 340);
	private Line windowLine3 = new Line(350, 310, 390, 310);
	private Line windowLine4 = new Line(370, 290, 370, 330);

    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
    	// Set the title for the stage.
    	primaryStage.setTitle("In-Class Lab 4: House");
    	
    	// set the width and the height values for the scene.
    	final double SCENE_WIDTH = 640.0;
    	final double SCENE_HEIGHT = 480.0;
    	 
    	// create a box for the body of the house.
    	Rectangle body = new Rectangle(200, 260, 240, 180);
    	body.setFill(Color.WHITE);
    	
    	// create two windows.
    	Rectangle window1 = new Rectangle(250, 290, 40, 40);
    	Rectangle window2 = new Rectangle(350, 290, 40, 40);
    	window1.setFill(Color.LIGHTSTEELBLUE);
    	windowLine1.setStroke(Color.WHITE);
    	windowLine2.setStroke(Color.WHITE);
    	window2.setFill(Color.LIGHTSTEELBLUE);
    	windowLine3.setStroke(Color.WHITE);
    	windowLine4.setStroke(Color.WHITE);
    	
    	
    	// create a door for the house.
    	Rectangle door = new Rectangle(290, 350, 60, 90);
    	door.setFill(Color.LIGHTSTEELBLUE);
    	Circle doorKnob = new Circle(340, 395, 3);
    	doorKnob.setFill(Color.WHITE);
    	doorBottom.setStroke(Color.WHITE);
    	
    	// create a roof for the house.
    	roof1.setStroke(Color.WHITE);
    	roof2.setStroke(Color.WHITE);

    	// add all the components of the house to the pane.
    	Pane pane = new Pane(roof1, roof2, body, window1, window2, door, doorKnob);
    	// add any remaining components of the house.
    	pane.getChildren().addAll(doorBottom, windowLine1, windowLine2, windowLine3, windowLine4);
    	pane.setStyle("-fx-background-color: LIGHTSTEELBLUE;");
    	
    	// register an event handler for the door.
    	door.setOnMouseClicked(event -> {
    		
    		// remove the door knob.
    		pane.getChildren().removeAll(door, doorKnob);
    		
    		// instantiate FadeTransition class. 
            FadeTransition fade = new FadeTransition();  
            
            // set the duration for the Fade transition.
            fade.setDuration(Duration.millis(5000));  
            
            // set the initial and the target opacity value for the transition.  
            fade.setFromValue(10);  
            fade.setToValue(0.1);  
              
            // set cycle count for the Fade transition.
            fade.setCycleCount(1000);  
              
            // set the transition to be auto reversed.   
            fade.setAutoReverse(true);  
              
            // apply the transition to the door.  
            fade.setNode(door);  
              
            // play the transition. 
            fade.play();  

    	});
    	
    	// register an event handler for the door knob.
    	doorKnob.setOnMouseEntered(event -> {
    		// scale the door knob.
    		doorKnob.setScaleX(3);
    		doorKnob.setScaleY(3);
    	});
    	
    	// register an event handler for the two windows.
    	window1.setOnMouseExited(event -> {
    		// turn on the lights for the first window.
    		window1.setFill(Color.YELLOW);
    	});
    	window2.setOnMouseExited(event -> {
    		// turn on the lights for the second window.
    		window2.setFill(Color.YELLOW);
    	});
    	
    	// display the scene.
    	Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
    	primaryStage.setScene(scene);
    	primaryStage.show();
        
    }

}
