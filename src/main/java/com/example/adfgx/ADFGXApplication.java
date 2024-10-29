package com.example.adfgx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ADFGXApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxml = new FXMLLoader(ADFGXApplication.class.getResource("adfgx-gui.fxml"));
        Scene scene = new Scene(fxml.load(), 600, 400);
        stage.setScene(scene);
        stage.setTitle("FairPlay Konštiak");
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}