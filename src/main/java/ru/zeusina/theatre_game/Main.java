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
    static ArrayList<Level> levels;
    static Level currentLevel;

    static Image fullscreen = null;

    static {
        levels = new ArrayList<>();
        try {
            Image hero = ImageIO.read(new File("image/hero.png"));
            ArrayList<Platform> level1Platforms = new ArrayList<>();
            level1Platforms.add(new Platform(0, 613, 190, 22));
            level1Platforms.add(new Platform(196, 718, 224, 38));
            level1Platforms.add(new Platform(531, 960, 183, 26));
            level1Platforms.add(new Platform(731, 593, 219, 25));
            level1Platforms.add(new Platform(1042, 925, 153, 20));
            level1Platforms.add(new Platform(1274, 774, 258, 28));
            level1Platforms.add(new Platform(1551, 964, 256, 28));
            level1Platforms.add(new Platform(1810, 767, 111, 27));
            level1Platforms.add(new Platform(1244, 413, 224, 27));

            ArrayList<Collectable> level1Collectables = new ArrayList<>();

            level1Collectables.add(new Star(305, 610));
            level1Collectables.add(new Star(799, 477));
            level1Collectables.add(new Star(1061, 804));
            level1Collectables.add(new Star(1276, 310));
            level1Collectables.add(new Star(620, 850));
            level1Collectables.add(new Star(1364, 663));
            level1Collectables.add(new Star(1820, 645));
            level1Collectables.add(new Icon(ImageIO.read(new File("image/collectables/robot.png")), 1650, 840));


            levels.add(new Level(ImageIO.read(new File("image/levels/1.png")), hero, level1Platforms,
                    level1Collectables, new Rectangle(1810, 571, 110, 195), 5, 378));

            ArrayList<Platform> level2Platforms = new ArrayList<>();

            level2Platforms.add(new Platform(0, 1056, 191, 23));
            level2Platforms.add(new Platform(204, 991, 195, 26));
            level2Platforms.add(new Platform(417, 939, 193, 23));
            level2Platforms.add(new Platform(625, 832, 194, 24));
            level2Platforms.add(new Platform(841, 649, 192, 22));
            level2Platforms.add(new Platform(1059, 648, 191, 24));
            level2Platforms.add(new Platform(1277, 399, 193, 23));
            level2Platforms.add(new Platform(1498, 344, 192, 22));
            level2Platforms.add(new Platform(1730, 343, 190, 24));

            ArrayList<Collectable> level2Collectables = new ArrayList<>();

            levels.add(new Level(ImageIO.read(new File("image/levels/2.jpg")), hero, level2Platforms,
                    level2Collectables, new Rectangle(1855, 157, 65, 185), 8, 876));

            ArrayList<Platform> level3Platforms = new ArrayList<>();

            level3Platforms.add(new Platform(0, 342, 193, 24));
            level3Platforms.add(new Platform(192, 651, 192, 24));
            level3Platforms.add(new Platform(414, 819, 192, 26));
            level3Platforms.add(new Platform(639, 653, 193, 24));
            level3Platforms.add(new Platform(856, 819, 192, 25));
            level3Platforms.add(new Platform(1061, 652, 193, 24));
            level3Platforms.add(new Platform(1264, 545, 193, 22));
            level3Platforms.add(new Platform(1506, 398, 190, 22));
            level3Platforms.add(new Platform(1730, 295, 191, 22));

            ArrayList<Collectable> level3Collectables = new ArrayList<>();

            levels.add(new Level(ImageIO.read(new File("image/levels/3.jpg")), hero, level3Platforms,
                    level3Collectables, new Rectangle(1857, 137, 64, 154), 11, 198));


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