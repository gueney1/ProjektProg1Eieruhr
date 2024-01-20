package com.example.projektprog1eieruhr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class EggTimerApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            stage.setTitle("Egg Timer");
            stage.setScene(new Scene(root));
            int fixedSize = 600;
            stage.setMinHeight(fixedSize);
            stage.setMinWidth(fixedSize);
            stage.setMaxHeight(fixedSize);
            stage.setMaxWidth(fixedSize);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}