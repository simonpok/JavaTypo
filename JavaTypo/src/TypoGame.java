import javax.swing.*;
import java.awt.*;

public class TypoGame extends JFrame {
    private Counter countdown; //GameTimerPanel
    private RandomWords randomWords; //WordGamePanel
    public TypoGame(){
        super("Java Typo");

        //GAME TIMER
        countdown = new Counter();
        randomWords = new RandomWords(countdown);
        add(countdown, BorderLayout.NORTH);
        add(randomWords, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setSize(400,600);

    }
}
