package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MP3Player {
    public String response = "";
    public Clip clip;

    public  void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("466000085_1345101506_1287973237.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
    }
    public  void play2() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("S5MT2PZ-basketball-sports-buzzer.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
    }
}
