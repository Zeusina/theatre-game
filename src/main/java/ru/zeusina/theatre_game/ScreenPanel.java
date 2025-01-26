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
        g.drawRect(Main.character.getX(), Main.character.getY(), Const.CHARACTER_WIDTH, Const.CHARACTER_HEIGHT);
        g.drawRect(Main.floor.x, Main.floor.y, Main.floor.width, Main.floor.height);
        g.drawRect(Main.character.getRec().x, Main.character.getRec().y, Main.character.getRec().width, Main.character.getRec().height);

        g.drawRect(Main.floor.x + 250, Main.floor.y - 40, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                update();

                repaint();

                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
