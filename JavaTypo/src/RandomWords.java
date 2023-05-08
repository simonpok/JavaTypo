import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RandomWords extends JPanel {
    private final JLabel wordCountLabel;
    private final JTextField wordField;
    private final Counter countdown;
    public JComboBox difficultyComboBox;
    private Difficulty difficulty;
    private int wordCount;
    public JButton  startButton;

    public RandomWords(Counter countdown) {

        this.countdown = countdown;

        setLayout(new BorderLayout());

        wordCountLabel = new JLabel("WPM: 0");
        add(wordCountLabel, BorderLayout.NORTH);

        wordField = new JTextField();
        wordField.setEditable(false);
        wordField.setHorizontalAlignment(SwingConstants.CENTER);
        add(wordField, BorderLayout.CENTER);

        difficultyComboBox = new JComboBox();
        difficultyComboBox.addItem("Easy");
        difficultyComboBox.addItem("Medium");
        difficultyComboBox.addItem("Hard");
        add(difficultyComboBox, BorderLayout.SOUTH);

        //Default value of Level
        difficulty = Difficulty.Easy;

        wordField.requestFocusInWindow();
        wordField.addKeyListener(new WordKeyListener(this));
        wordField.setFont(new Font("Arial", Font.BOLD, 24));



        startButton = new JButton("Start");
        startButton.setBounds(20, 20, 100, 25);
        add(startButton, BorderLayout.WEST);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                // Disable the difficulty combo box
                difficultyComboBox.disable();
                countdown.start();
                generateWord();

            }
        });

    }
    public enum Difficulty {
        Easy,
        Medium,
        Hard
    }
    private void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void generateWord() {

        String[] words;
        switch (difficulty){
            case Easy:
                words = new String[]{"apple", "banana", "cherry", "orange", "pear"};
                break;
            case Medium:
                words = new String[]{"computer", "television", "telephone", "newspaper", "dictionary"};
                break;
            case Hard:
                words = new String[]{"blockchain", "robotics", "cybersecurity", "intelligence", "quantum"};
                break;
            default:
                words = new String[]{"apple", "banana", "cherry", "orange", "pear"};
                break;
        }
        Random random = new Random();
        int index = random.nextInt(words.length);

        wordField.setText(words[index]);

    }

    public int getWordCount(){
        return wordCount;
    }

    private class WordKeyListener extends KeyAdapter {
        private RandomWords randomWords;

        public WordKeyListener(RandomWords randomWords) {
            this.randomWords = randomWords;
        }
        @Override
        public void keyTyped(KeyEvent e) {

            if (e.getKeyChar() == wordField.getText().charAt(0)) {
                wordField.setText(wordField.getText().substring(1));
                if (wordField.getText().isEmpty()) {
                    generateWord();
                    wordCount++;

                    // Update word count label
                    wordCountLabel.setText("WPM: " + wordCount);
                    countdown.setWordCount(wordCount);

                    // Set difficulty

                    Difficulty difficulty = Difficulty.valueOf(difficultyComboBox.getSelectedItem().toString()); //Value need to be change to String
                    randomWords.setDifficulty(difficulty);
                }
            }
        }
    }
}
