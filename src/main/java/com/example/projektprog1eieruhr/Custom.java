package com.example.projektprog1eieruhr;

public class Custom extends EggTimer {
    //Der Konstruktor der Übergeordneten Klasse wird aufgerufen
    public Custom(int durationInSeconds) {
        super(durationInSeconds);
    }

    //Gibt den Timer Namen Custom zurück
    public String getTimerName() {
        return "Custom Timer";
    }
}