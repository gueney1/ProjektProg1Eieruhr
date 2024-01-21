package com.example.projektprog1eieruhr;

import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public abstract class EggTimer extends Task<Void> {
    // Dauer in Sekunden
    private final int durationInSeconds;
    //Konstruktor
    public EggTimer(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    // Die Methode "call" ruft zuerst die Methode "playStartClickSound" auf. Danach
    // wird die Zeit in Sekunden heruntergespielt/gelooped/gezählt.
    // Am Ende erfolgt eine Textausgabe, um den Benutzer darüber zu informieren, dass der Timer abgelaufen ist.
    // Der Text wird von einem Warnsignal in Form eines Alarms begleitet.

    public Void call() throws Exception {
        playStartClickSound();
        for (int i = durationInSeconds; i > 0 && !isCancelled(); i--) {
            updateMessage(formatTime(i));
            Thread.sleep(1000);
        }

        updateMessage(getTimerName() + " - Done");
        playAlarm();
        return null;
    }
    // Die abstrakte Methode "getTimerName" gibt den Namen des Timers zurück, der diese Methode aufruft.
    public abstract String getTimerName();

    // Die Methode "formatTime" gibt die Zeit in korrekter Formatierung zurück.

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    // Die Methode "playAlarm" spielt ein Warnsignal am Ende des Timers ab.
    private void playAlarm() {
        try {
            String audioFilePath = "src/main/resources/betterAlarm.mp3";
            Media media = new Media(new File(audioFilePath).toURI().toString());
            MediaPlayer audio = new MediaPlayer(media);
            audio.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Die Methode "playStartClickSound" spielt beim Starten eines Timers.
    private void playStartClickSound() {
        try {
            String audioFilePath = "src/main/resources/start.mp3";
            Media media = new Media(new File(audioFilePath).toURI().toString());
            MediaPlayer audio = new MediaPlayer(media);
            audio.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}