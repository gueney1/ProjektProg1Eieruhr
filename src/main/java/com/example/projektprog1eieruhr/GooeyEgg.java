package com.example.projektprog1eieruhr;

public class GooeyEgg extends EggTimer {
    public GooeyEgg(int durationInSeconds) {
        super(durationInSeconds);
    }

    @Override
    public String getTimerName() {
        return "Gooey Egg Timer";
    }
}