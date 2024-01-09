package com.example.projektprog1eieruhr;

public class SoftEgg extends EggTimer {
    public SoftEgg(int durationInSeconds) {
        super(durationInSeconds);
    }

    @Override
    public String getTimerName() {
        return "Soft Egg Timer";
    }
}
