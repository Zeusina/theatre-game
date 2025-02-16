package ru.zeusina.theatre_game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static Hero character = new Hero();
    static Floor floor = new Floor();
    static ArrayList<Platform> platforms = new ArrayList<>();
    static Image background;
    static Image hero;

    static {
        try {
            background = ImageIO.read(new File("image/levels/1.jpg"));
            hero = ImageIO.read(new File("image/hero.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        platforms.add(new Platform(floor.x, floor.y - 445 - 22, 190, 22));
        platforms.add(new Platform(floor.x + 196, floor.y - 38 - 318, 224, 38));
        platforms.add(new Platform(floor.x + 531, floor.y - 92 - 28, 183, 26));
        platforms.add(new Platform(floor.x + 731, floor.y - 462 - 25, 219, 25));
        platforms.add(new Platform(floor.x + 1042, floor.y - 135 - 20, 153, 20));
        platforms.add(new Platform(floor.x + 1274, floor.y - 278 - 28, 258, 28));
        platforms.add(new Platform(floor.x + 1551, floor.y - 88 - 28, 256, 28));
        platforms.add(new Platform(floor.x + 1810, floor.y - 286 - 27, 111, 27));
        platforms.add(new Platform(floor.x + 1244, floor.y - 640 - 27, 224, 27));








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