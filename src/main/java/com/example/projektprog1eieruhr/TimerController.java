package com.example.projektprog1eieruhr;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TimerController {
    @FXML
    private Label customLabel;
    @FXML
    private Label gooeyEggLabel;
    @FXML
    private Label hardEggLabel;
    @FXML
    private Label softEggLabel;


    @FXML
    void startGooeyEggTimer(ActionEvent event) {
        GooeyEgg gooeyEgg = new GooeyEgg(300);
        new Thread(gooeyEgg).start();
        gooeyEggLabel.textProperty().bind(gooeyEgg.messageProperty());
    }

    @FXML
    void startHardEggTimer(ActionEvent event) {
        HardEgg hardEgg = new HardEgg(600);
        new Thread(hardEgg).start();
        hardEggLabel.textProperty().bind(hardEgg.messageProperty());
    }

    @FXML
    void startSoftEggTimer(ActionEvent event) {
        SoftEgg softEgg = new SoftEgg(180);
        new Thread(softEgg).start();
        softEggLabel.textProperty().bind(softEgg.messageProperty());
    }

    @FXML
    void startCustomTimer(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Custom Timer");
        dialog.setHeaderText("Enter duration in seconds:");
        dialog.setContentText("Duration:");
        dialog.showAndWait();
        try{
            int customDuration = Integer.parseInt(dialog.getResult());
            Custom custom = new Custom(customDuration);
            new Thread(custom).start();
            customLabel.textProperty().bind(custom.messageProperty());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Oh no!");
            alert.setHeaderText(null);
            alert.setContentText("Invalid number!");
            alert.showAndWait();
        }
    }
}