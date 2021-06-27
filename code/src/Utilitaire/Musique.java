package Utilitaire;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
/**
 * Player de sons wav
 * ajout de fonctions a la class AePlayWave
 * http://www.fobec.com/java/1043/jouer-son-musique-format-wav.html
 * -> pause et reprendre la lecture
 * -> arreter la lecture
 * -> calculer la progression de lecture.
 * @author fobec 2011 *
 */
public class Musique extends Thread {
 
    private String filename;
    private Position curPosition;
    private final int EXTERNAL_BUFFER_SIZE = 65536; // 16Kb
    private boolean isSuspend = false;
    private boolean isCanceled = false;
    private int readpercent = 0;
 
    enum Position {
 
        LEFT, RIGHT, NORMAL
    };
 
    /**
     * Constructeur: fixer le fichier wav
     * @param wavfile
     */
    public Musique(String wavfile) {
        filename = wavfile;
        curPosition = Position.NORMAL;
    }
 
    /**
     * Mettre en pause ou reprendre la lecture
     */
    public synchronized void pause() {
        if (this.isSuspend == true) {
            this.isSuspend = false;
        } else {
            this.isSuspend = true;
        }
        notify();
    }
 
    /**
     * Abandonner la lecture
     */
    public synchronized void cancel() {
        this.isCanceled = true;
        notify();
    }
 

    /**
     * Connaitre la progression de lecture
     * @return
     */
    public int getProgress() {
        return this.readpercent;
    }
 
    public void run() {
        File soundFile = new File(filename);
        if (!soundFile.exists()) {
            System.err.println("Wave file not found: ");
            return;
        }
 
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
 
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
 
        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
 
        if (auline.isControlSupported(FloatControl.Type.PAN)) {
            FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
            if (curPosition == Position.RIGHT) {
                pan.setValue(1.0f);
            } else if (curPosition == Position.LEFT) {
                pan.setValue(-1.0f);
            }
        }
 
        auline.start();
        int nBytesRead = 0;
        //longueur du fichier wav
        Long audiolength = soundFile.length();
        int audioreaded = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
 
        try {
            while (nBytesRead != -1 && this.isCanceled == false) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    //calcul de la progression
                    readpercent = Math.round(audioreaded * 100 / audiolength);
                    auline.write(abData, 0, nBytesRead);
                    audioreaded = nBytesRead;
                }
                /**
                 * Annuler la lecture
                 */
                if (this.isCanceled == true) {
                    System.out.print("Thread has been stopped");
                    break;
                }
               /**
                 * Mettre en pause
                 */
                if (this.isSuspend == true) {
                    while (this.isSuspend == true) {
                        try {
                            Thread.sleep(250);
                            if (this.isCanceled == true) {
                                System.out.print("Thread has been stopped");
                                break;
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Musique.class.getName()).log(Level.SEVERE,
 
			 null, ex);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }
    }
}