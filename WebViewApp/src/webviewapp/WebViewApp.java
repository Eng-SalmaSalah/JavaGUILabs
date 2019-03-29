/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webviewapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author salma
 */
public class WebViewApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        WebViewDesignBase webdesignview=new WebViewDesignBase(primaryStage);
        Scene scene = new Scene(webdesignview, 600, 400);
        primaryStage.setTitle("My webView App");
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
