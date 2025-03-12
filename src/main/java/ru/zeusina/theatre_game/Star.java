package ru.zeusina.theatre_game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Star implements Collectable{
    Image icon;

    int x;
    int y;

    boolean isVisible = true;

    Rectangle trigger;

    @Override
    public void onCollect() {
        isVisible = false;
    }

    public Star(Image icon, int x, int y) {
        this.icon = icon;
        this.x = x;
        this.y = y;
        this.trigger = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
    }

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            this.icon = ImageIO.read(new File("image/collectables/star.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.trigger = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
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

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public Rectangle getTrigger() {
        return trigger;
    }
}
