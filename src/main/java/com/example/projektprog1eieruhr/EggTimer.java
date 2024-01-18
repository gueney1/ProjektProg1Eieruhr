package com.example.projektprog1eieruhr;

import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


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
        playAudioClip();
        return null;
    }

    public abstract String getTimerName();

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    private void playAudioClip() {
        try {
            String audioFilePath = "C:\\Users\\gnars\\IdeaProjects\\ProjektProg1Eieruhr\\src\\main\\resources\\sound\\alarm.mp3";
            Media media = new Media(new File(audioFilePath).toURI().toString());
            MediaPlayer audio = new MediaPlayer(media);
            audio.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}