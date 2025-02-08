package ru.zeusina.theatre_game;

import java.awt.*;

public class Hero {
    private int x = 100, y = 100;

    private Rectangle rec = new Rectangle(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);

    private int speedX, speedY = 0;

    private boolean isInAir = false;
    private int jumpTicks = 0;

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

        if (isInAir) {
            if (jumpTicks > 0) {
                speedY = -Const.JUMP_STRENGTH;
                jumpTicks--;
            } else {
                speedY = Const.SPEED;
            }
        }
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
            jumpTicks = Const.JUMP_DURATION;
            speedY = -Const.JUMP_STRENGTH;
            isInAir = true;
        }
    }

    private void collision() {
        boolean onPlatform = false;
        if (rec.intersects(Main.floor)) {
            y = Main.floor.y - Const.CHARACTER_HEIGHT+1;
            isInAir = false;
            speedY = 0;
            onPlatform = true;
        }

        for (Platform platform : Main.platforms) {
            if (rec.intersects(platform)) {
                y = platform.y - Const.CHARACTER_HEIGHT+1;
                isInAir = false;
                speedY = 0;
                onPlatform = true;
                break;
            }
        }

        if (!onPlatform) {
            isInAir = true;
        }
    }
}