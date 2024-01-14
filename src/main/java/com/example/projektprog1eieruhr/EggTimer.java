package com.example.projektprog1eieruhr;

import javafx.concurrent.Task;

public abstract class EggTimer extends Task<Void> {
    private final int durationInSeconds;

    public EggTimer(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    protected Void call() throws Exception {
        for (int i = durationInSeconds; i > 0 && !isCancelled(); i--) {
            updateMessage(formatTime(i));
            Thread.sleep(1000);
        }

        updateMessage(getTimerName() + " - Done");
        return null;
    }

    public abstract String getTimerName();

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
