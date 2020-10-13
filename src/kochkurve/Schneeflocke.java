package kochkurve;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Schneeflocke extends Canvas
{
    Random r;
    enum Point{        int x,y;};
    public Schneeflocke()
    {
        setSize(800,600);
        setBackground(Color.gray);
        r = new Random();
    }
    public void paint(Graphics g)
    {
        super.paint(g);
       g.setColor(Color.CYAN);
       g.fillOval(r.nextInt(600),100,200,200);;
       g.drawLine(0,0,100,100);

    }
    public void test()
    {
       Timer t = new Timer(r.nextInt(1000),(e)->{paint(getGraphics());});
       t.start();
    }
}
