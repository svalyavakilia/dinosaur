package dinosaurgame.entities;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ShortCactus {
    private final int y;
    private final int spawnX;

    private Image shortCactusImage;

    private int x;

    private int vel;

    public ShortCactus() {
        y = 275;
        spawnX = 825;
        shortCactusImage = new ImageIcon("Resources\\Short cactus.png").getImage();
        x = 800;
        vel = 1;
    }

    public Image getShortCactusImage() {
        return shortCactusImage;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVel() {
        return vel;
    }

    public int getSpawnX() {
        return spawnX;
    }
}