module com.example.projektprog1eieruhr {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.projektprog1eieruhr to javafx.fxml;
    exports com.example.projektprog1eieruhr;
}