package com.example.test1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tesztelés");
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        DB db = new DB();
        db.getData();
        ViewController viewController = fxmlLoader.getController();
        viewController.setFrszTable();

    }

    public static void main(String[] args) {
        launch(args);

    }
}
