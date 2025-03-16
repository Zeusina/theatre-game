package ru.zeusina.theatre_game;

import ru.zeusina.theatre_game.scripts.PostImageScript;
import ru.zeusina.theatre_game.scripts.level3ImageScript;

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
    static ArrayList<Level> levels;
    static Level currentLevel;

    public static Fullscreen fullscreen = null;

    static {
        levels = new ArrayList<>();
        try {
            Image hero = ImageIO.read(new File("image/hero.png"));
            ArrayList<Platform> level1Platforms = new ArrayList<>();
            level1Platforms.add(new Platform(3, 250, 190, 22));
            level1Platforms.add(new Platform(4, 825, 190, 26));
            level1Platforms.add(new Platform(215, 538, 208, 22));
            level1Platforms.add(new Platform(678, 535, 193, 23));
            level1Platforms.add(new Platform(670, 843, 195, 20));
            level1Platforms.add(new Platform(542, 246, 192, 22));
            level1Platforms.add(new Platform(992, 399, 194, 20));
            level1Platforms.add(new Platform(1411, 270, 193, 21));
            level1Platforms.add(new Platform(1639, 556, 194, 23));
            level1Platforms.add(new Platform(1470, 937, 189, 27));
            level1Platforms.add(new Platform(1731, 791, 190, 23));


            ArrayList<Collectable> level1Collectables = new ArrayList<>();

            level1Collectables.add(new Star(264, 410));
            level1Collectables.add(new Star(698, 730));
            level1Collectables.add(new Star(1049, 289));
            level1Collectables.add(new Star(1485, 810));


            levels.add(new Level(ImageIO.read(new File("image/levels/1.png")), hero, level1Platforms,
                    level1Collectables, new Rectangle(1920, 0, 50, 1080), 5, 378,
                    new level3ImageScript(), null));

            ArrayList<Platform> level2Platforms = new ArrayList<>();

            level2Platforms.add(new Platform(0, 997, 192, 23));
            level2Platforms.add(new Platform(191, 803, 191, 22));
            level2Platforms.add(new Platform(382, 550, 194, 25));
            level2Platforms.add(new Platform(582, 372, 192, 24));
            level2Platforms.add(new Platform(848, 647, 139, 22));
            level2Platforms.add(new Platform(1074, 439, 169, 22));
            level2Platforms.add(new Platform(1268, 765, 382, 18));
            level2Platforms.add(new Platform(1463, 296, 194, 22));
            level2Platforms.add(new Platform(1726, 650, 195, 24));

            ArrayList<Collectable> level2Collectables = new ArrayList<>();

            level2Collectables.add(new Star(241, 688));
            level2Collectables.add(new Star(881, 551));
            level2Collectables.add(new Star(1368, 639));
            level2Collectables.add(new Star(1806, 494));


            levels.add(new Level(ImageIO.read(new File("image/levels/2.png")), hero, level2Platforms,
                    level2Collectables, new Rectangle(1806, 494, 115, 157), 15, 710,
                    null, new PostImageScript()));

            currentLevel = levels.getFirst();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


        ScreenPanel screenPanel = new ScreenPanel();

        Screen screen = new Screen();
        screen.add(screenPanel);

        Thread thread = new Thread(screenPanel);
        thread.start();
        currentLevel.preLevel();

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