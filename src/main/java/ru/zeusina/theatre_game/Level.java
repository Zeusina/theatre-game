package ru.zeusina.theatre_game;

import java.awt.*;
import java.util.ArrayList;

public class Level {
    private Image background;
    private Image hero;

    private ArrayList<Platform> platforms;

    private Rectangle checkpoint;

    private int startX;
    private int startY;

    public Level(Image background, Image hero, ArrayList<Platform> platforms, Rectangle checkpoint, int startX, int startY) {
        this.background = background;
        this.hero = hero;
        this.platforms = platforms;
        this.checkpoint = checkpoint;
        this.startX = startX;
        this.startY = startY;
    }

    public Image getBackground() {
        return background;
    }

    public Image getHero() {
        return hero;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public Rectangle getCheckpoint() {
        return checkpoint;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
