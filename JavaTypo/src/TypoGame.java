import javax.swing.*;
import java.awt.*;

public class TypoGame extends JFrame {
    private Counter countdown;
    private RandomWords randomWords;
    public TypoGame(){
        super("Java Typo");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        countdown = new Counter();
        randomWords = new RandomWords(countdown);

        add(countdown, BorderLayout.NORTH);
        add(randomWords, BorderLayout.CENTER);

        setVisible(true);
    }
}
