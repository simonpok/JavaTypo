import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
    private JLabel countdownLabel;
    private int countdown;
    private Timer timer;
    private boolean running;
    private int wordCount;

    RandomWords randomWords = new RandomWords(this);

    public Counter(){
        setLayout(new BorderLayout());

        countdownLabel = new JLabel("60");
        Font countdownFont = new Font("Courier", Font.BOLD, 50);
        countdownLabel.setFont(countdownFont);
        countdownLabel.setForeground(Color.black);
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));
        add(countdownLabel, BorderLayout.NORTH);

//        generateWord();

        start();
        running = false;
    }
    public void start(){
//        new Timer(1000, e->{
//            int countdown = Integer.parseInt(countdownLabel.getText());
//            countdown--;
//            countdownLabel.setText(Integer.toString(countdown));
//            if(countdown == 0){
//                ((Timer)e.getSource()).stop();
//            }
//        }).start();
        countdown = 60;
        running = true;
        countdownLabel.setText(Integer.toString(countdown));
        timer = new Timer(1000, e -> {  //150
            int countdown = Integer.parseInt(countdownLabel.getText());
            countdown--;
            countdownLabel.setText(Integer.toString(countdown));
            if(countdown == 0){
                stop();
            }
        });
        timer.start();
    }
    public void stop() {
        running = false;
        timer.stop();
        int result = JOptionPane.showConfirmDialog(this, "Game over! WPM: " + wordCount + ". Would you like to play again?", "Game over", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            reset();
        } else {
            System.exit(0);
        }
    }
    public void reset() {
        countdownLabel.setText("60");
        running = false;
        start();
//        timer.stop();
    }

    public int getCount() {


        int wordCount = randomWords.getWordCount();
        return wordCount;
//        return Integer.parseInt(countdownLabel.getText());
//        return Integer.parseInt(String.valueOf(wordCount));
    }

    public boolean isRunning() {
        return running;
    }

    public void setWordCount(int count) {
        wordCount = count;
    }
}

