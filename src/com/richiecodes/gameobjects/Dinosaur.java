package com.richiecodes.gameobjects;

import com.richiecodes.util.Animation;
import com.richiecodes.util.Resource;

import java.awt.*;

import static com.richiecodes.ui.GameScreen.GRAVITY;
import static com.richiecodes.ui.GameScreen.GROUND_Y;

public class Dinosaur {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation spriteRun;

    public Dinosaur() {
        spriteRun = new Animation(500);
        spriteRun.addFrame(Resource.getResourceImage("src/com/richiecodes/assets/main-character1.png"));
        spriteRun.addFrame(Resource.getResourceImage("src/com/richiecodes/assets/main-character2.png"));
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect((int) x, (int) y, spriteRun.getFrame().getWidth(), spriteRun.getFrame().getHeight());
        g.drawImage(spriteRun.getFrame(), (int) x, (int) y, null);
    }

    public void jump() {
        speedY = -4.0f;
        y += speedY;
    }

    public void update() {
        spriteRun.update();
        if(y >= GROUND_Y - spriteRun.getFrame().getHeight()) {
            speedY = 0;
            y = GROUND_Y - spriteRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
