package ru.zeusina.theatre_game;

import java.awt.*;

public class Fullscreen {
    Image image;
    int time;

    public Fullscreen(Image image, int time) {
        this.image = image;
        this.time = time;
    }

    public Image getImage() {
        return image;
    }

    public int getTime() {
        return time;
    }
}
