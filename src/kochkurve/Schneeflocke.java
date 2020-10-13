package kochkurve;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Schneeflocke extends Canvas
{
    public class Point
    {
        public int x, y;
        public Point(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    private Random r;
    private ArrayList<Point> points;
    public Schneeflocke()
    {
        setSize(800,600);
        setBackground(Color.darkGray);
        r = new Random();
        points = new ArrayList<>();
        points.add(new Point(100,100));
        points.add(new Point(200,100));
        points.add(new Point(150,100+(int)(50*Math.sqrt(3))));
        points.add(new Point(100,100));
    }
    public void paint(Graphics g)
    {
        super.paint(g);
       g.setColor(Color.white);
       Polygon polygon = new Polygon();
        for(Point p : points)
            polygon.addPoint(p.x,p.y);
        g.drawPolygon(polygon);
    }
    public void test()
    {
       Timer t = new Timer(1000,(e)->{
            ArrayList<Point> newpoints = new ArrayList<>();
           for(int i=0;i<points.size()-1;i++)
           {
               Point oldpoint = points.get(i);
               newpoints.add(oldpoint);

           }
           paint(getGraphics());
       });
       t.start();
    }
}
