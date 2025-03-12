package ru.zeusina.theatre_game;

import java.awt.*;

public interface Collectable {

    void onCollect();

    int getX();
    int getY();

    Image getIcon();
    boolean isVisible();

    Rectangle getTrigger();

}
