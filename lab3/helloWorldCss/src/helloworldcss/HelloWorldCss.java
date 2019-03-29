/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldcss;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author salma
 */
public class HelloWorldCss extends Application {
    
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
        rectangle.setId("rect");
        
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
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
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
