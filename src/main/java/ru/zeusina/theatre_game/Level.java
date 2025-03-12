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

    private ArrayList<Collectable> collectables;

    public Level(Image background, Image hero, ArrayList<Platform> platforms, ArrayList<Collectable> collectables, Rectangle checkpoint, int startX, int startY) {
        this.background = background;
        this.hero = hero;
        this.platforms = platforms;
        this.checkpoint = checkpoint;
        this.startX = startX;
        this.startY = startY;
        this.collectables = collectables;
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

    public ArrayList<Collectable> getCollectables() {
        return collectables;
    }
}
