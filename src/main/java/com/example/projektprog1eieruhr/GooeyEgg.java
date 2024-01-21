package com.example.projektprog1eieruhr;

public class GooeyEgg extends EggTimer {
    //Der Konstruktor der Übergeordneten Klasse wird aufgerufen
    public GooeyEgg(int durationInSeconds) {
        super(durationInSeconds);
    }
    //Gibt den Timer Namen Custom zurück
    public String getTimerName() {
        return "Gooey Egg Timer";
    }
}