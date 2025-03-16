package ru.zeusina.theatre_game.scripts;

import ru.zeusina.theatre_game.Fullscreen;
import ru.zeusina.theatre_game.Main;
import ru.zeusina.theatre_game.Script;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PostImageScript implements Script, Runnable {
    @Override
    public void run() {
        try {
            Main.fullscreen = new Fullscreen(ImageIO.read(new File("image/fullscreen/level-passed.png")), 5 * 1000);
            Thread.sleep(5 * 1000);
//            Main.fullscreen = new Fullscreen(ImageIO.read(new File("image/fullscreen/final_1.png")), 10 * 1000);
//            Thread.sleep(10 * 1000);
//            Main.fullscreen = new Fullscreen(ImageIO.read(new File("image/fullscreen/final_2.png")), 30 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
