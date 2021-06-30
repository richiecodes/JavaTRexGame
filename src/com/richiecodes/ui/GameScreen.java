package com.richiecodes.ui;

import com.richiecodes.gameobjects.Dinosaur;
import com.richiecodes.gameobjects.Land;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 0.1F;
    public static final float GROUND_Y = 100F;

    private Dinosaur dino;
    private Land land;

    private Thread thread;

    public GameScreen() {
        thread = new Thread(this);
        dino = new Dinosaur();
        land = new Land(this);
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                land.update();
                dino.update();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.drawLine(0, (int) GROUND_Y, getWidth(), (int) GROUND_Y);
        land.draw(g);
        dino.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        dino.jump();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}
