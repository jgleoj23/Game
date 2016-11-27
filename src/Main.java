import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by josephgardi on 11/25/16.
 */
public class Main  extends JFrame {
    private static final Integer WIDTH = 1430;
    private static final Integer HEIGHT = 850;


    public static void main(String[] args) {
        String[] arguments = {"G "};
        G mp = new G();
        PApplet.runSketch(arguments, mp);
//        PApplet applet = new G();
//        applet.g = applet.createGraphics(WIDTH, HEIGHT, PApplet.P2D);
    }
}
