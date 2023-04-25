import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RandomWords extends JPanel {


    private JTextField wordField;
    private int wordCount;

    public RandomWords() {
        setLayout(new BorderLayout());

        wordField = new JTextField();
        wordField.setEditable(false);
        wordField.setHorizontalAlignment(SwingConstants.CENTER);
        add(wordField, BorderLayout.CENTER);

        generateWord();
        wordField.requestFocusInWindow();
        wordField.addKeyListener(new WordKeyListener());
    }

    public void generateWord() {
        String[] words = {"apple", "banana", "cherry", "orange", "pear"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        wordField.setText(words[index]);
    }

    public int getWordCount() {
        return wordCount;
    }

    private class WordKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == wordField.getText().charAt(0)) {
                wordField.setText(wordField.getText().substring(1));
                if (wordField.getText().isEmpty()) {
                    generateWord();
                    wordCount++;
                }
            }
        }
    }
}
