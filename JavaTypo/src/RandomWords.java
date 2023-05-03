import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RandomWords extends JPanel {
    private JLabel wordCountLabel;
    private JTextField wordField;
    private Counter countdown;
    private int wordCount;
    private Difficulty difficulty;
    private JComboBox difficultyComboBox;

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

        difficulty = Difficulty.Easy;

        generateWord();
        wordField.requestFocusInWindow();
        wordField.addKeyListener(new WordKeyListener(this));
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
//                    Difficulty difficulty = (Difficulty) difficultyComboBox.getSelectedItem(); //Value need to be change to String
//                    this.randomWords.setDifficulty(difficulty);
                    Difficulty difficulty = Difficulty.valueOf(difficultyComboBox.getSelectedItem().toString());
                    randomWords.setDifficulty(difficulty);
                }
            }
        }
    }
}
