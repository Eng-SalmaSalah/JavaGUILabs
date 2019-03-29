package webviewapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewDesignBase extends AnchorPane {

    protected final WebView webView;
    protected final TextArea textArea;

    public WebViewDesignBase(Stage stage) {
        Map<String, List<String>> headers;
        URLConnection connection = null;
        String htmlScript = null;

        webView = new WebView();
        textArea = new TextArea();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        webView.setLayoutY(178.0);
        webView.setPrefHeight(222.0);
        webView.setPrefWidth(600.0);

        textArea.setLayoutX(-1.0);
        textArea.setLayoutY(-1.0);
        textArea.setPrefHeight(170.0);
        textArea.setPrefWidth(600.0);

        getChildren().add(webView);
        getChildren().add(textArea);

        URL url;
        try {
            url = new URL("https://www.google.com.eg/");
            try {
                connection = url.openConnection();
                connection.connect();
                headers = connection.getHeaderFields();
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    for (String value : entry.getValue()) {
                        textArea.appendText(key + ": " + value + "\n");
                        //System.out.println(key + ": " + value);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        String encoding = connection.getContentEncoding();
        if (encoding == null) {
            encoding = "UTF-8";
        }
        try {
            Scanner in = new Scanner(connection.getInputStream(),encoding);
            while(in.hasNext()){
            String line=in.nextLine();
            htmlScript+=line;
            }
            webView.getEngine().loadContent(htmlScript);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
