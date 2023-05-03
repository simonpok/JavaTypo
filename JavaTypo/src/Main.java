import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        Counter countdown = new Counter();
        RandomWords randomWords = new RandomWords(countdown);

        JFrame frame = new JFrame("Java Typo");
        frame.setSize(400,600);
        frame.add(countdown, BorderLayout.NORTH);
        frame.add(randomWords, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
