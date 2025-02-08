package ru.zeusina.theatre_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {
    static Hero character = new Hero();
    static Floor floor = new Floor();
    static ArrayList<Platform> platforms = new ArrayList<>();

    public static void main(String[] args) {
        platforms.add(new Platform(floor.x + 100, floor.y - 50, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT));
        platforms.add(new Platform(floor.x + 300, floor.y - 100, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT));
        platforms.add(new Platform(floor.x + 500, floor.y - 150, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT));
        platforms.add(new Platform(floor.x + 200, floor.y - 200, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT));
        platforms.add(new Platform(floor.x + 400, floor.y - 250, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT));


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