package com.example.projektprog1eieruhr;

public class HardEgg extends EggTimer {
    public HardEgg(int durationInSeconds) {
        super(durationInSeconds);
    }

    @Override
    public String getTimerName() {
        return "Hard Egg Timer";
    }
}
