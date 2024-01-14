package com.example.projektprog1eieruhr;

public class Custom extends EggTimer {
    public Custom(int durationInSeconds) {
        super(durationInSeconds);
    }

    @Override
    public String getTimerName() {
        return "Custom Timer";
    }
}