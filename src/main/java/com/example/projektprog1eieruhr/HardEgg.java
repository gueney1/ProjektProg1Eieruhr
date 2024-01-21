package com.example.projektprog1eieruhr;

public class HardEgg extends EggTimer {
    //Der Konstruktor der Übergeordneten Klasse wird aufgerufen
    public HardEgg(int durationInSeconds) {
        super(durationInSeconds);
    }

    //Gibt den Timer Namen Custom zurück
    public String getTimerName() {
        return "Hard Egg Timer";
    }
}