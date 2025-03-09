package ru.zeusina.theatre_game;

import java.awt.*;

public class Hero {
    private int x = 5, y = 378;

    private Rectangle downCollider = new Rectangle(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);
    private Rectangle upCollider = new Rectangle(x, y, Const.CHARACTER_WIDTH, 10);

    private Rectangle leftCollider = new Rectangle(x, y, 5, Const.CHARACTER_HEIGHT);
    private Rectangle rightCollider = new Rectangle(x + Const.CHARACTER_WIDTH - 5, y, 5, Const.CHARACTER_HEIGHT);


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

    public Rectangle getDownCollider() {
        return downCollider;
    }

    public Rectangle getUpCollider() {
        return upCollider;
    }

    public Rectangle getLeftCollider() {
        return leftCollider;
    }

    public Rectangle getRightCollider() {
        return rightCollider;
    }

    public void update() {
        x += speedX;
        y += speedY;
        downCollider.setBounds(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);
        upCollider.setBounds(x, y, Const.CHARACTER_WIDTH, 10);
        leftCollider.setBounds(x, y, 5, Const.CHARACTER_HEIGHT);
        rightCollider.setBounds(x + Const.CHARACTER_WIDTH - 5, y, 5, Const.CHARACTER_HEIGHT);


        if (isInAir) {
            if (jumpTicks > 0) {
                speedY = -Const.JUMP_STRENGTH;
                jumpTicks--;
            } else {
                speedY = Const.SPEED;
            }
        }
        collision();
        checkTrigger();
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
        if (downCollider.intersects(Main.floor)) {
            y = Main.floor.y - Const.CHARACTER_HEIGHT + 1;
            isInAir = false;
            speedY = 0;
            onPlatform = true;
        }

        for (Platform platform : Main.currentLevel.getPlatforms()) {
            if (downCollider.intersects(platform)) {
                y = platform.y - Const.CHARACTER_HEIGHT + 1;
                isInAir = false;
                speedY = 0;
                onPlatform = true;
                break;
            }
            if (upCollider.intersects(platform)) {
                y = platform.y + Const.PLATFORM_HEIGHT + 5;
                speedY = 0;
                jumpTicks = 0;
                break;
            }
            if (leftCollider.intersects(platform)) {
                speedX = 0;
                x = platform.x + Const.PLATFORM_WIDTH + 1;
                break;
            }
            if (rightCollider.intersects(platform)) {
                speedX = 0;
                x = platform.x - Const.CHARACTER_WIDTH;
                break;
            }
        }

        if (!onPlatform) {
            isInAir = true;
        }
    }

    private void checkTrigger() {
        Rectangle trigger = Main.currentLevel.getCheckpoint();

        if (downCollider.intersects(trigger) || upCollider.intersects(trigger)
                || leftCollider.intersects(trigger) || rightCollider.intersects(trigger)) {
            if (Main.levels.size() > 1) {
                Main.levels.remove(0);
                Main.currentLevel = Main.levels.getFirst();
                x = Main.currentLevel.getStartX();
                y = Main.currentLevel.getStartY();
            }

        }

    }
}