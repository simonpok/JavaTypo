import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
    private static final int COUNTDOWN_SECONDS = 60;
    private JLabel countdownLabel;
    private int countdown;
    private Timer timer;
    private boolean running = false;
    private int wordCount;
    private JButton startButton;
    private RandomWords randomWords;
    public Counter(){

        setLayout(new BorderLayout());

        countdownLabel = new JLabel(Integer.toString(COUNTDOWN_SECONDS));
        Font countdownFont = new Font("Courier", Font.BOLD, 50);
        countdownLabel.setFont(countdownFont);
        countdownLabel.setForeground(Color.black);
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));
        add(countdownLabel, BorderLayout.NORTH);
    }
    public void start(){
            countdown = 60;
            countdownLabel.setText(Integer.toString(countdown));

            timer = new Timer(1000, e -> {  //150
                int countdown = Integer.parseInt(countdownLabel.getText());
                countdown--;
                countdownLabel.setText(Integer.toString(countdown));
                if (countdown == 0) {
                    stop();
                }
            });
            timer.start();

    }
    public void stop() {
        RandomWords randomWords = new RandomWords(this);
        timer.stop();
        int result = JOptionPane.showConfirmDialog(this, "Game over! WPM: " + wordCount + ". Would you like to play again?", "Game over", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            reset();
            randomWords.difficultyComboBox.setEnabled(true);
            randomWords.startButton.setVisible(true);
        } else {
            System.exit(0);
        }
    }
    public void reset() {
        countdownLabel.setText("60");

        start();
    }
    public void setWordCount(int count) {
        wordCount = count;
    }
}