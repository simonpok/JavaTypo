import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

public class Sound {
    private static Clip backgroundClip;
    static {
        try {
            AudioInputStream audioBackgroundInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(Sound.class.getResource("sound/backgroundMusic.wav")));
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioBackgroundInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void typeSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(Sound.class.getResource("sound/keyboardClick.wav")));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public static void backgroundSound(int checkSound) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (checkSound == 1 && !backgroundClip.isRunning()) {
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        } else if (checkSound == 0 && backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
    }
}
