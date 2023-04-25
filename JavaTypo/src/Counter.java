import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
    private JLabel countdownLabel;

    public Counter(){
        setLayout(new BorderLayout());

        countdownLabel = new JLabel("60");
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 36));
        countdownLabel.setHorizontalAlignment((SwingConstants.CENTER));
        add(countdownLabel, BorderLayout.NORTH);



        startCountdown();
    }
    public void startCountdown(){
        new Timer(1000, e->{
            int countdown = Integer.parseInt(countdownLabel.getText());
            countdown--;
            countdownLabel.setText(Integer.toString(countdown));
            if(countdown == 0){
                ((Timer)e.getSource()).stop();
            }
        }).start();
    }

}