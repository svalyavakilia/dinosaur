package dinosaurgame.entities;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Ground {
    private Image groundImage;

    private int x;
    private int y;

    private int vel;

    public Ground() {
        groundImage = new ImageIcon("Resources\\Ground.png").getImage();
        x = 0;
        y = 325;
        vel = 1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVel() {
        return vel;
    }

    public Image getGroundImage() {
        return groundImage;
    }
}
