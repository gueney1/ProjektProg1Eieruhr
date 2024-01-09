package com.example.projektprog1eieruhr;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private TextField customDurationField;

    @FXML
    void startGooeyEggTimer(ActionEvent event) {
        GooeyEgg gooeyEgg = new GooeyEgg(300); // Beispiel: 5 Minuten für den Gooey Egg Timer
        new Thread(gooeyEgg).start();
        gooeyEggLabel.textProperty().bind(gooeyEgg.messageProperty());
    }

    @FXML
    void startHardEggTimer(ActionEvent event) {
        HardEgg hardEgg = new HardEgg(600); // Beispiel: 10 Minuten für den Hard Egg Timer
        new Thread(hardEgg).start();
        hardEggLabel.textProperty().bind(hardEgg.messageProperty());
    }

    @FXML
    void startSoftEggTimer(ActionEvent event) {
        SoftEgg softEgg = new SoftEgg(180); // Beispiel: 3 Minuten für den Soft Egg Timer
        new Thread(softEgg).start();
        softEggLabel.textProperty().bind(softEgg.messageProperty());
    }

    @FXML
    void startCustomTimer(ActionEvent event) {
        try {
            String input = customDurationField.getText();
            int durationInSeconds = Integer.parseInt(input);

            Custom custom = new Custom(durationInSeconds);
            customLabel.textProperty().bind(custom.messageProperty());

            // Erstelle einen Hintergrund-Task und führe ihn in einem separaten Thread aus, funktioniert noch nicht
            Task<Void> customTask = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        while (custom.getTimeInSeconds() > 0 && !isCancelled()) {
                            updateMessage(custom.getMessage());
                            custom.updateTime();
                            Thread.sleep(1000);
                        }
                        updateMessage("Done");
                    } catch (Exception e) {
                        e.printStackTrace(); // Fügen Sie diese Zeile für Debugging-Zwecke hinzu
                    }
                    return null;
                }
            };

            // Führe den Task in einem separaten Thread aus
            Thread customThread = new Thread(customTask);
            customThread.setDaemon(true);
            customThread.start();
        } catch (NumberFormatException e) {
            customLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
    @FXML
    private void goToTimers() {
        // Implement the logic to go to the timers
        // You can use FXMLLoader to load another FXML file or change the scene
        // For now, let's just display an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Go to Timers");
        alert.setHeaderText(null);
        alert.setContentText("This is where you would go to the timers.");
        alert.showAndWait();
    }
}