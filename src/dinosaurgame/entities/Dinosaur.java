package dinosaurgame.entities;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Dinosaur {
    private final int runningY;
    private Image dinosaurImage;
    private int x;
    private int y;

    private boolean ableToJump;
    private boolean goingUp;
    private boolean goingDown;

    private int jumpMax;

    private int yVel;

    public Dinosaur() {
        runningY = 225;
        dinosaurImage = new ImageIcon("Resources\\Dinosaur.png").getImage();
        x = 50;
        y = 225;
        ableToJump = false;
        goingUp = false;
        goingDown = false;
        jumpMax = 25;
        yVel = 2;
    }

    public void jump() {
        if (goingUp) {
            y -= yVel;
            if (y == jumpMax) {
                goingUp = false;
                goingDown = true;
            }
        }
        if (goingDown) {
            y += yVel;
            if (y == runningY) {
                goingDown = false;
                setAbleToJump(false);
            }
        }
    }

    public void setAbleToJump(boolean ableToJump) {
        this.ableToJump = ableToJump;
        setGoingUp(true);
    }

    public boolean isAbleToJump() {
        return ableToJump;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getDinosaurImage() {
        return dinosaurImage;
    }

    public void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }
}