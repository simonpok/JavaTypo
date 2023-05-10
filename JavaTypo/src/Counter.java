import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
    private static final int DEFAULT_COUNTDOWN_SECONDS = 60;
    private JLabel countdownLabel;
    private int countdown;
    private Timer timer;
    private int wordCount;
    private double accuracyCount;
    public   RandomWords randomWords;


    public Counter(){

        this.randomWords = new RandomWords(this);

        setLayout(new BorderLayout());

        countdownLabel = new JLabel(Integer.toString(DEFAULT_COUNTDOWN_SECONDS));
        Font countdownFont = new Font("Courier", Font.BOLD, 50);
        countdownLabel.setFont(countdownFont);
        countdownLabel.setForeground(Color.black);
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));
        add(countdownLabel, BorderLayout.NORTH);

    }

    public void start(){
            countdown = DEFAULT_COUNTDOWN_SECONDS;
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
        timer.stop();
        int result = JOptionPane.showConfirmDialog(this, "Game over! WPM: " + wordCount + " Accuracy: " + (accuracyCount < 0 ? 0 : String.format("%.0f", accuracyCount)) + "%. Would you like to play again?", "Game over", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            reset();

        } else {
            System.exit(0);
        }
    }
    public void reset() {
        countdownLabel.setText("60");
        randomWords.startButton.setVisible(true);

        start();
    }

    public void setWordCount(int count) {
        wordCount = count;
    }
    public  void setAccuracyCount(double count){
        accuracyCount = count;
    }
}