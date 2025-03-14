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

    private Runnable preLevel;
    private Runnable postLevel;

    public Level(Image background, Image hero, ArrayList<Platform> platforms, ArrayList<Collectable> collectables,
                 Rectangle checkpoint, int startX, int startY, Runnable preLevel, Runnable postLevel) {
        this.background = background;
        this.hero = hero;
        this.platforms = platforms;
        this.checkpoint = checkpoint;
        this.startX = startX;
        this.startY = startY;
        this.collectables = collectables;
        this.preLevel = preLevel;
        this.postLevel = postLevel;
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

    public void preLevel() {
        if (preLevel != null) {
            Thread thread = new Thread(preLevel);
            thread.start();
        }
    }

    public void postLevel() {
        if (postLevel != null) {
            Thread thread = new Thread(postLevel);
            thread.start();
        }
    }
}
