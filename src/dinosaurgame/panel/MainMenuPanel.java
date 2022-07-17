package dinosaurgame.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static java.awt.Font.BOLD;
import static javax.swing.JLabel.CENTER;

public class MainMenuPanel extends JPanel {
    private static final Font font;
    private static final Color buttonColor;

    static {
        font = new Font(null, BOLD, 25);
        buttonColor = new Color(178, 160, 74);
    }

    private final JLabel record;
    private final JButton play;
    private final JButton exit;

    {
        record = new JLabel();
        play = new JButton();
        exit = new JButton();
    }

    public MainMenuPanel() {
        setPreferredSize(new Dimension(800, 400));
        setLayout(null);
        setBackground(new Color(220, 205, 130));

        String record = null;

        try (final BufferedReader br = new BufferedReader(
                        new FileReader("resources\\record.txt"))) {
            record = br.readLine();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }

        this.record.setBounds(300, 25, 200, 25);
        this.record.setText("Record: " + record);
        this.record.setFont(font);
        this.record.setHorizontalAlignment(CENTER);

        play.setBounds(300, 100, 200, 90);
        play.setText("Play!");
        play.setFont(font);
        play.setBackground(buttonColor);
        play.setBorder(null);
        play.addActionListener(listener -> changeThisPanelToGamePanel());
        play.setFocusable(false);

        exit.setBounds(300, 210, 200, 90);
        exit.setText("Exit!");
        exit.setFont(font);
        exit.setBackground(buttonColor);
        exit.setBorder(null);
        exit.addActionListener(listener -> System.exit(0));
        exit.setFocusable(false);

        add(this.record);
        add(play);
        add(exit);
    }

    private void changeThisPanelToGamePanel() {
        final JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        window.setContentPane(new GamePanel());
        window.pack();
    }
}