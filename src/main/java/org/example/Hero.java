package org.example;

import java.awt.*;

public class Hero {
    private int x = 100, y = 100;

    private Rectangle rec = new Rectangle(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);

    private int speedX, speedY = Const.SPEED;

    private boolean isInAir = true;

    public void moveRight() {
        speedX = Const.SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRec() {
        return rec;
    }

    public void update() {
        x += speedX;
        y += speedY;
        rec.setBounds(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);
        collision();
    }

    public void stop() {
        speedX = 0;
    }

    public void moveLeft() {
        speedX = -Const.SPEED;
    }

    public void jump() {
        if (!isInAir) {
            y -= Const.JUMP_STRENGTH;
            isInAir = true;
        }

    }

    private void collision() {
        if (rec.intersects(Main.floor)) {
            y = Main.floor.y - Const.CHARACTER_HEIGHT;
            isInAir = false;
        }
    }
}
