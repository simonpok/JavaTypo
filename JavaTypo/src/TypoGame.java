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
        setResizable(true);
        setVisible(true);


        //GAME TIMER
        countdown = new Counter();
        randomWords = new RandomWords(countdown);

        add(countdown, BorderLayout.NORTH);
        add(randomWords, BorderLayout.CENTER);


    }
}
