
// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Alert
{
    // Fields storing the path to the alerts for a price movement upwards and a price movement downwards
    public static String upPath = "";
    public static String downPath = "";

    // To store the current position in the audio clip
    static Clip clip;

    // The current status of clip
    static String status;

    // Audio stream
    static AudioInputStream audioInputStream;

    // Method to play the audio alert for an upward movement in price
    public static void playUp()
    {
        // Create AudioInputStream object from up alert file path
        try
        {
            audioInputStream = AudioSystem.getAudioInputStream(new File(upPath).getAbsoluteFile());
        }
        catch (UnsupportedAudioFileException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Setting the clip field to the clip created from the above file
        try
        {
            clip = AudioSystem.getClip();
        }
        catch (LineUnavailableException e)
        {
            e.printStackTrace();
        }

        // Open audioInputStream to the clip
        try
        {
            clip.open(audioInputStream);
        }
        catch (LineUnavailableException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Start the clip
        clip.start();
        status = "play";
    }
    public static void playDown()
    {
        // Create AudioInputStream object from up alert file path
        try
        {
            audioInputStream = AudioSystem.getAudioInputStream(new File(downPath).getAbsoluteFile());
        }
        catch (UnsupportedAudioFileException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Setting the clip field to the clip created from the above file
        try
        {
            clip = AudioSystem.getClip();
        }
        catch (LineUnavailableException e)
        {
            e.printStackTrace();
        }

        // Open audioInputStream to the clip
        try
        {
            clip.open(audioInputStream);
        }
        catch (LineUnavailableException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Start the clip
        clip.start();
        status = "play";
    }
}
