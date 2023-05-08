import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JLabel wordCountLabel;
    private JLabel countdownLabel;
    private JButton startGame;
    private JComboBox difficultyComboBox;
    private JTextField wordField;
    private JPanel mainPanel;
    private static final int COUNTDOWN_SECONDS = 60;
    private int countdown;
    private Timer timer;
    private boolean running = false;
    private int wordCount;
    public GUI() {
        setContentPane(mainPanel);
        setTitle("JavaTypo");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        countdownLabel.setFont(new Font("Arial", Font.BOLD, 36));
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame.setEnabled(false);
                difficultyComboBox.setEnabled(false);
                start();
//                randomWords.generateWord();
                wordField.requestFocus();
            }
        });
    }

    public void start() {
        countdown = COUNTDOWN_SECONDS;
        running = true;
        countdownLabel.setText(Integer.toString(countdown));
        timer = new Timer(1000, e -> {
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
//        RandomWords randomWords = new RandomWords(this);
        running = false;
        timer.stop();
        int result = JOptionPane.showConfirmDialog(this, "Game over! WPM: " + wordCount + ". Would you like to play again?", "Game over", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            reset();
            difficultyComboBox.setEnabled(true);
            startGame.setEnabled(true);
            wordField.setText("");
        } else {
            System.exit(0);
        }
    }

    public void reset() {
        countdownLabel.setText(Integer.toString(COUNTDOWN_SECONDS));
        running = false;
        start();
    }

    public void setWordCount(int count) {
        wordCount = count;
        wordCountLabel.setText("WPM: " + wordCount);
    }

}
