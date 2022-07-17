import dinosaurgame.DinosaurGame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> DinosaurGame.start());
    }
}