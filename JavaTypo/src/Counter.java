import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JPanel {
    private static final int COUNTDOWN_SECONDS = 60;
    private JLabel countdownLabel;
    private int countdown;
    private Timer timer;
    private boolean running = false;
    private int wordCount;
    private JButton startButton;
    public Counter(){

        RandomWords randomWords = new RandomWords(this);

        setLayout(new BorderLayout());

        countdownLabel = new JLabel(Integer.toString(COUNTDOWN_SECONDS));
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 36));
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));
        add(countdownLabel, BorderLayout.NORTH);

//        startButton = new JButton("Start");
//        add(startButton, BorderLayout.SOUTH);
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startButton.setEnabled(false);
//                randomWords.difficultyComboBox.disable();
//                start();
//                randomWords.generateWord();
//
//            }
//        });

        //Start button

    }

    public void start(){

            countdown = 60;
            running = true;
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
        running = false;
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
        running = false;
        start();
    }

    public void setWordCount(int count) {
        wordCount = count;
    }
}