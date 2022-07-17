package dinosaurgame.panel;

import dinosaurgame.entities.Dinosaur;
import dinosaurgame.entities.Ground;
import dinosaurgame.entities.MediumDryTree;
import dinosaurgame.entities.ShortCactus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    private final JButton jump;
    private final Dinosaur dinosaur;
    private final ShortCactus sc;
    private final MediumDryTree mdt;
    private final Ground ground;
    private final JLabel score;
    private String record;
    private double distance;

    {
        jump = new JButton();
        dinosaur = new Dinosaur();
        sc = new ShortCactus();
        mdt = new MediumDryTree();
        ground = new Ground();
        score = new JLabel();

        try (BufferedReader br = new BufferedReader
                (new FileReader("Resources\\Record.txt"))) {
            record = br.readLine();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }

        distance = 0;
    }

    public GamePanel() {
        setPreferredSize(new Dimension(800, 400));
        setLayout(null);
        setBackground(new Color(220, 205, 130));

        score.setBounds(600, 60, 175, 25);
        score.setBackground(new Color(178, 160, 74));
        score.setOpaque(true);
        score.setFont(new Font(null, Font.BOLD, 15));
        score.setHorizontalAlignment(JLabel.CENTER);
        add(score);

        score.setBounds(600, 25, 175, 25);
        score.setBackground(new Color(178, 160, 74));
        score.setOpaque(true);
        score.setFont(new Font(null, Font.BOLD, 15));
        score.setHorizontalAlignment(JLabel.CENTER);
        add(score);

        jump.setBounds(300, 25, 200, 60);
        jump.setBackground(new Color(178, 160, 74));
        jump.setBorder(null);
        jump.setFont(new Font(null, Font.BOLD, 21));
        jump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinosaur.setAbleToJump(true);
            }
        });
        add(jump);

        Timer timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        jump.requestFocus();

        distance += 0.0625;
        score.setText("Current score: " + (int) distance);

        g.drawImage(ground.getGroundImage(), ground.getX(), ground.getY(), this);
        ground.setX(ground.getX() - ground.getVel());
        if (ground.getX() == -800) {
            ground.setX(0);
        }

        g.drawImage(dinosaur.getDinosaurImage(), dinosaur.getX(), dinosaur.getY(), this);

        g.drawImage(sc.getShortCactusImage(), sc.getX(), sc.getY(), this);
        sc.setX(sc.getX() - sc.getVel());
        if (sc.getX() == -25) {
            sc.setX(sc.getSpawnX());
        }

        g.drawImage(mdt.getMediumDryTreeImage(), mdt.getX(), mdt.getY(), this);
        mdt.setX(mdt.getX() - mdt.getVel());
        if (mdt.getX() == -50) {
            mdt.setX(mdt.getSpawnX());
        }

        if (dinosaur.isAbleToJump()) {
            dinosaur.jump();
            jump.setEnabled(false);
        } else {
            jump.setEnabled(true);
        }

        if ((dinosaur.getY() + 100 >= sc.getY()
            &&
            sc.getX() + 12.5 >= dinosaur.getX()
            &&
            sc.getX() <= dinosaur.getX() + 80)

            ||

            (dinosaur.getY() + 100 >= mdt.getY()
            &&
            mdt.getX() + 25 >= dinosaur.getX()
            &&
            mdt.getX() <= dinosaur.getX() + 80)) {

            if ((int) distance > Integer.parseInt(record)) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("Resources\\Record.txt"))) {
                    bw.write(String.valueOf((int) distance));
                } catch (IOException IOE) {
                    IOE.printStackTrace();
                }
            }

            changeThisPanelToEndGamePanel();
        }
    }

    private void changeThisPanelToEndGamePanel() {
        final JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        window.setContentPane(new EndGamePanel((int) distance));
        window.pack();
    }
}