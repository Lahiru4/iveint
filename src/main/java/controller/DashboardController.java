package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import util.MP3Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public TextField time;
    public JFXTextField stopTime;

    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    private String time_number;
    private boolean opt = false;
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            time_number = hours_string + ":" + minutes_string + ":" + seconds_string + "";
            time.setText(time_number);
            if (stopTime.getText().equals(time_number)) {
                stop();
                playMpEnd();
            }

        }
    });
    MP3Player mp3Player1;
    private void playMp3_Wo() {
        mp3Player1= new MP3Player();
        try {
            mp3Player1.play();
            mp3Player1.clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    MP3Player mp3PlayerEND;
    private void playMpEnd() {
        mp3PlayerEND= new MP3Player();
        try {
            mp3PlayerEND.play2();
            mp3PlayerEND.clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
        mp3Player1.clip.stop();
    }

    void reset() {
        stopTime.clear();
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        time.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }

    public void staartOnAction(javafx.event.ActionEvent actionEvent) {
        playMp3_Wo();
        start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        time.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }

    public void stopOnAction(javafx.event.ActionEvent actionEvent) {
        stop();
    }

    public void resetOnAction(javafx.event.ActionEvent actionEvent) {
        reset();
    }
}
