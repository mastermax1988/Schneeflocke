package kochkurve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class mainClass
{
    public static void main(String[] args)
    {
        Frame frame = new Frame("Schnee");
        Schneeflocke schneeflocke = new Schneeflocke();
        frame.add(schneeflocke);
        frame.setSize(800, 600);
        frame.setVisible(true);
        schneeflocke.test();
    }
}

