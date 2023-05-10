import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SplashScreen {

    private int count = 0;

    public SplashScreen() {

        TitledBorder border = new TitledBorder(BorderFactory.createRaisedBevelBorder(), "JAVATYPO", TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
        border.setTitleFont(new Font("Gotham light", Font.BOLD, 24));
        border.setTitleColor(Color.RED);

        JLabel logoImg = new JLabel("by Sandip Shrestha & Kshitiz Adhikari", (new ImageIcon(getClass().getResource("graphics/splashLogo.png"))), JLabel.CENTER);
        logoImg.setFont(new Font("Gotham light", Font.PLAIN, 14));
        logoImg.setHorizontalTextPosition(JLabel.CENTER);
        logoImg.setVerticalTextPosition(JLabel.BOTTOM);
        logoImg.setForeground(Color.RED);
        JProgressBar progressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 3);
        progressBar.setBorder(border);

        EventQueue.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            JWindow frame = new JWindow();
            frame.setAlwaysOnTop(true);
            frame.setSize(400, 600);
            frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        SwingUtilities.getWindowAncestor(e.getComponent()).dispose();
                    }
                }
            });
            frame.setBackground(new Color(0, 0, 0, 0));
            frame.setLayout(new BorderLayout());
            frame.add(logoImg, BorderLayout.CENTER);
            frame.add(progressBar, BorderLayout.SOUTH);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setIconImage((new ImageIcon(getClass().getResource("graphics/JTLogo.png"))).getImage());


            new Timer(800, e -> {
                progressBar.setValue(count);
                if (count == 4) {
                    ((Timer) e.getSource()).stop();
                    frame.dispose();
                    new TypoGame().setLocationRelativeTo(null);
                }
                count++;
            }).start();

        });
    }

}