package com.richiecodes.ui;

import javax.swing.*;

public class GameWindow extends JFrame {

    private GameScreen gameScreen;

    public GameWindow() {
        super("T-Rex Game Protoype thingy");
        this.setSize(600, 175);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        gameScreen = new GameScreen();
        this.add(gameScreen);

        this.addKeyListener(gameScreen);
    }

    public void startGame() {
        gameScreen.startGame();
    }

    public static void main(String[] args) {
        GameWindow gw = new GameWindow();
        gw.setVisible(true);
        gw.startGame();
    }
}
