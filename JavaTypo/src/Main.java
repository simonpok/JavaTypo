import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        Counter countdown = new Counter();
        RandomWords randomWords = new RandomWords();

        JPanel panel = new JPanel(new GridLayout(1, 2));
//        panel.add(countdown,BorderLayout.NORTH);
//        panel.add(randomWords,BorderLayout.CENTER);

        JFrame frame = new JFrame("Java Typo");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(countdown, BorderLayout.NORTH);
        frame.add(randomWords, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        countdown.startCountdown();
    }

}
