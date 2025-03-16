package ru.zeusina.theatre_game;

import javax.swing.*;
import java.awt.*;

public class ScreenPanel extends JPanel implements Runnable {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void update() {
        Main.character.update();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Main.currentLevel.getBackground(), 0, 0, null);
        g.drawImage(Main.currentLevel.getHero(), Main.character.getX(), Main.character.getY(), null);
        if (Const.DEBUG) {
            g.drawRect(Main.character.getX(), Main.character.getY(), Const.CHARACTER_WIDTH, Const.CHARACTER_HEIGHT);
            g.drawRect(Main.floor.x, Main.floor.y, Main.floor.width, Main.floor.height);
            g.setColor(Color.RED);
            g.drawRect(Main.character.getDownCollider().x, Main.character.getDownCollider().y, Main.character.getDownCollider().width, Main.character.getDownCollider().height);
            g.setColor(Color.BLUE);
            g.drawRect(Main.character.getUpCollider().x, Main.character.getUpCollider().y, Main.character.getUpCollider().width, Main.character.getUpCollider().height);
            g.setColor(Color.CYAN);
            g.drawRect(Main.character.getLeftCollider().x, Main.character.getLeftCollider().y, Main.character.getLeftCollider().width, Main.character.getLeftCollider().height);
            g.setColor(Color.GREEN);
            g.drawRect(Main.character.getRightCollider().x, Main.character.getRightCollider().y, Main.character.getRightCollider().width, Main.character.getRightCollider().height);
            g.setColor(Color.BLACK);


            for (Platform block : Main.currentLevel.getPlatforms()) {
                g.drawRect(block.x, block.y, block.width, block.height);
            }
        }

        for (Collectable collectable : Main.currentLevel.getCollectables()) {
            if (collectable.isVisible()) {
                if (Const.DEBUG) {
                    g.drawRect(collectable.getTrigger().x, collectable.getTrigger().y, collectable.getTrigger().width, collectable.getTrigger().height);
                }
                g.drawImage(collectable.getIcon(), collectable.getX(), collectable.getY(), null);
            }
        }

        if (Const.DEBUG) {
            g.setColor(Color.ORANGE);
            g.drawRect(Main.currentLevel.getCheckpoint().x, Main.currentLevel.getCheckpoint().y, Main.currentLevel.getCheckpoint().width, Main.currentLevel.getCheckpoint().height);
            g.setColor(Color.BLACK);
        }
        

        if (Main.fullscreen != null) {
            g.drawImage(Main.fullscreen.getImage(), 0, 0, null);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                update();

                repaint();
                if (Main.fullscreen != null) {
                    try {
                        Thread.sleep(Main.fullscreen.getTime());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Main.fullscreen = null;
                }

                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
