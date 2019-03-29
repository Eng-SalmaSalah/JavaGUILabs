/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author salma
 */
public class HelloWorldJavaFx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);
        //creating rectangle(background) bec we cannot add colour to scene
        Rectangle rectangle=new Rectangle();
        rectangle.setX(0); 
        rectangle.setY(0); 
        rectangle.setWidth(300); 
        rectangle.setHeight(250);
        //adding gradient
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE),new Stop(0.5, Color.WHITE),new Stop(1, Color.BLACK)};
        LinearGradient lg1 = new LinearGradient(1, 1, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        rectangle.setFill(lg1);
        //creating text
        Text helloWorld=new Text("Hello World!");
        
        //editing text font
        helloWorld.setFill(Color.RED);
        helloWorld.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
        //adding reflection
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        helloWorld.setEffect(r);
        //adding nodess to scene
        root.getChildren().add(rectangle);
        root.getChildren().add(helloWorld);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
