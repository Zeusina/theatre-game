package ru.zeusina.theatre_game.scripts;

import ru.zeusina.theatre_game.Fullscreen;
import ru.zeusina.theatre_game.Main;
import ru.zeusina.theatre_game.Script;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class level3ImageScript implements Script, Runnable {
    @Override
    public void run() {
        try {
        Main.fullscreen = new Fullscreen(ImageIO.read(new File("image/fullscreen/init.png")), 10 * 1000);
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
