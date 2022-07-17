package dinosaurgame.panel;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndGamePanel extends JPanel {
    public EndGamePanel(int distance) {
        setPreferredSize(new Dimension(800, 400));
        setLayout(null);

        setBackground(new Color(220, 205, 130));

        EventListener listener = new EventListener();

        JLabel yourScore = new JLabel("Your score: " + distance + "!");
        yourScore.setBounds(300, 25, 200, 25);
        yourScore.setFont(new Font(null, Font.BOLD, 21));
        yourScore.setHorizontalAlignment(JLabel.CENTER);
        add(yourScore);

        JButton replay = new JButton("Replay");
        replay.setBounds(300, 100, 200, 90);
        replay.setBackground(new Color(178, 160, 74));
        replay.setBorder(null);
        replay.setFont(new Font(null, Font.BOLD, 30));
        replay.addActionListener(listener);
        add(replay);

        JButton exit = new JButton("Exit");
        exit.setBounds(300, 210, 200, 90);
        exit.setBackground(new Color(178, 160, 74));
        exit.setBorder(null);
        exit.setFont(new Font(null, Font.BOLD, 30));
        exit.addActionListener(listener);
        add(exit);
    }

    private void changeThisPanelToGamePanel() {
        JFrame GameFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        GameFrame.setContentPane(new GamePanel());
        GameFrame.pack();
    }

    private class EventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            if (source.getText().equals("Replay"))
                changeThisPanelToGamePanel();

            if (source.getText().equals("Exit"))
                System.exit(0);
        }
    }
}