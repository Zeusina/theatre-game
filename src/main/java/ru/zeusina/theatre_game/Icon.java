package ru.zeusina.theatre_game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Icon implements Collectable {
    private Image icon;

    private int x;
    private int y;

    private boolean isVisible = true;

    private Rectangle trigger;

    public Icon(Image icon, int x, int y) {
        this.icon = icon;
        this.x = x;
        this.y = y;
        this.trigger = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
    }

    @Override
    public void onCollect() {
        isVisible = false;
        try {
            Main.fullscreen = ImageIO.read(new File("image/black.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Image getIcon() {
        return icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public Rectangle getTrigger() {
        return trigger;
    }
}
