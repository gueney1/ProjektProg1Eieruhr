package com.example.projektprog1eieruhr;

public class SoftEgg extends EggTimer {
    //Der Konstruktor der Übergeordneten Klasse wird aufgerufen
    public SoftEgg(int durationInSeconds) {
        super(durationInSeconds);
    }

    //Gibt den Timer Namen Custom zurück
    public String getTimerName() {
        return "Soft Egg Timer";
    }
}