package org.example.com_javarush_popkov_cryptoanalyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CaesarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CaesarApplication.class.getResource("cryptoanalyzer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 912, 751);
        stage.setTitle("Cryptoanalyzer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}