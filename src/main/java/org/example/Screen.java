package org.example;

import javax.swing.*;

public class Screen extends JFrame {

    public Screen() {
        setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        setLocation(300, 100);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
