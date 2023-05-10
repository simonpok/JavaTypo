import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
    private static final int DEFAULT_COUNTDOWN_SECONDS = 60; //The default countdown time in seconds.
    private static final int DEFAULT_COUNTDOWN_SPEED = 1000; //The default countdown speed in milliseconds.
    private int wordCount; //The number of words typed.
    private int countdown; //The number of seconds remaining in the countdown.
    private double accuracyCount; //The accuracy of the player.
    private Timer timer; //The timer used to count down the time.
    private JLabel countdownLabel; //The label that display the countdown time.
    public   RandomWords randomWords; //The RandomWords object that generates the words.


    public Counter(){
        // Set the layout of the panel to BorderLayout.
        setLayout(new BorderLayout());

        // Create the countdown label and set its font, foreground color, and horizontal alignment.
        countdownLabel = new JLabel(Integer.toString(DEFAULT_COUNTDOWN_SECONDS));
        Font countdownFont = new Font("Courier", Font.BOLD, 50);
        countdownLabel.setFont(countdownFont);
        countdownLabel.setForeground(Color.black);
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));
        add(countdownLabel, BorderLayout.NORTH);

    }
    /**
     * Starts the countdown.
     */
    public void start(){
            countdown = DEFAULT_COUNTDOWN_SECONDS;
            countdownLabel.setText(Integer.toString(countdown));

            timer = new Timer(DEFAULT_COUNTDOWN_SPEED, e -> {  //150
                int countdown = Integer.parseInt(countdownLabel.getText());
                countdown--;
                countdownLabel.setText(Integer.toString(countdown));
                if (countdown == 0) {
                    stop();
                }
            });
            timer.start();

    }
    /**
     * Stops the countdown and displays the game over message.
     */
    public void stop() {
        new RandomWords(this);
        timer.stop();
        int result = JOptionPane.showConfirmDialog(null, "Game over! WPM: " + wordCount + " Accuracy: " + (accuracyCount < 0 ? 0 : String.format("%.0f", accuracyCount)) + "%. Would you like to play again?", "Game over", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            reset();
//            randomWords.difficultyComboBox.setEnabled(true);
//            randomWords.startButton.setVisible(true);
        } else {
            System.exit(0);
        }
    }
    /**
     * Resets the countdown to the default value.
     */
    public void reset() {
        // Set the countdown label to display the default countdown time.
        countdownLabel.setText("60");
        // Start the countdown.
        start();
    }
    /**
     * Sets the word count.
     *
     * count The new word count.
     */
    public void setWordCount(int count) {
        wordCount = count;
    }
    /**
     * Sets the accuracy count.
     *
     * count The new accuracy count.
     */
    public  void setAccuracyCount(double count){
        accuracyCount = count;
    }
}