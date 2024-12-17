package Util;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioPlayer {

    public static void playAudioLoop(String filePath) {
        new Thread(() -> {
            try {
                // Load the audio file
                File audioFile = new File(filePath);
                if (!audioFile.exists()) {
                    System.err.println("Audio file not found: " + filePath);
                    return;
                }

                // Create an audio stream
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                // Obtain the audio clip
                Clip audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);

                // Loop the audio continuously
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);

                // Start playback
                audioClip.start();
                System.out.println("Audio is now playing in a loop.");

            } catch (UnsupportedAudioFileException e) {
                System.err.println("The specified audio file format is not supported.");
            } catch (IOException | LineUnavailableException e) {
                System.err.println("Error playing audio: " + e.getMessage());
            }
        }).start(); // Run in a separate thread
    }
    public static void playSoundOnceAsync(String soundFilePath) {
        new Thread(() -> {
            try {
                // Play the sound asynchronously in a separate thread
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new java.io.File(soundFilePath));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                
                clip.start();
                
                // Wait for the sound to finish before closing the clip
                while (!clip.isRunning()) {
                    Thread.sleep(10);  // Busy-wait until the sound starts
                }
                while (clip.isRunning()) {
                    Thread.sleep(10);  // Busy-wait until the sound finishes
                }
                clip.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start(); // Start the thread
    }
    
}
