package dinosaurgame.entities;

import java.awt.Image;
import javax.swing.ImageIcon;

public class MediumDryTree {
    private final int y;
    private final int spawnX;

    private Image mediumDryTreeImage;

    private int x;
    private int vel;

    public MediumDryTree() {
        y = 250;
        spawnX = 800;
        mediumDryTreeImage = new ImageIcon("Resources\\Medium dry tree.png").getImage();
        x = 1200;
        vel = 1;
    }

    public int getY() {
        return y;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public Image getMediumDryTreeImage() {
        return mediumDryTreeImage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVel() {
        return vel;
    }
}