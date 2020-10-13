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
        public Point(double x, double y)
        {
            this((int)x, (int) y);
        }
        public String toString()
        {
            return x + " " + y;
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
               Point oldpoint2 = points.get(i+1);

               int x1=oldpoint.x;
               int x2 = oldpoint2.x;
               int y1 = oldpoint.y;
               int y2 = oldpoint2.y;
               double newlength = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2))/3.0;
               double angleedge = Math.atan(((double)(y2-y1))/(double)(x2-x1));
               double angle = Math.PI - angleedge - Math.PI/6;
               System.out.println(angleedge/2/Math.PI*360);
               newpoints.add(oldpoint);
               System.out.println(newpoints);
           }
           newpoints.add(points.get(0));
           points = newpoints;
           paint(getGraphics());
       });
       t.start();
    }
}
