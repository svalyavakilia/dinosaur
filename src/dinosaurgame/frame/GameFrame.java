package dinosaurgame.frame;

import dinosaurgame.panel.MainMenuPanel;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        setContentPane(new MainMenuPanel());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Run!osaur");
        setVisible(true);
    }
}