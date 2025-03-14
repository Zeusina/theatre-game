package ru.zeusina.theatre_game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level {
    private Image background;
    private Image hero;

    private Image heroRight;
    private Image heroLeft;

    private ArrayList<Platform> platforms;

    private Rectangle checkpoint;

    private int startX;
    private int startY;

    private ArrayList<Collectable> collectables;

    private Runnable preLevel;
    private Runnable postLevel;

    public Image getHeroRight() {
        return heroRight;
    }

    public Image getHeroLeft() {
        return heroLeft;
    }

    public Level(Image background, Image hero, ArrayList<Platform> platforms, ArrayList<Collectable> collectables,
                 Rectangle checkpoint, int startX, int startY, Runnable preLevel, Runnable postLevel) {
        this.background = background;
        this.hero = hero;
        this.heroRight = hero;
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-hero.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        Image hero_flip = op.filter((BufferedImage) hero, null);
        this.heroLeft = hero_flip;

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

    public void setHero(Image hero) {
        this.hero = hero;
    }
}
