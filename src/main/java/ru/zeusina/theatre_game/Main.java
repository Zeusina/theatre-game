package ru.zeusina.theatre_game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    static Hero character = new Hero();
    static Floor floor = new Floor();

    public static void main(String[] args) {

        ScreenPanel screenPanel = new ScreenPanel();

        Screen screen = new Screen();
        screen.add(screenPanel);

        Thread thread = new Thread(screenPanel);
        thread.start();

        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE -> System.exit(0);
                    case KeyEvent.VK_SPACE -> character.jump();
                    case KeyEvent.VK_D -> character.moveRight();
                    case KeyEvent.VK_A -> character.moveLeft();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_D -> character.stop();
                    case KeyEvent.VK_A -> character.stop();
                }
            }
        });

    }
}