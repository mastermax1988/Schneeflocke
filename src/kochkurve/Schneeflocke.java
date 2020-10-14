package kochkurve;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Schneeflocke extends Canvas
{

    private ArrayList<Vector2D> points;

    public Schneeflocke()
    {
        setSize(800,800);
        setBackground(Color.darkGray);
        initPoints();
    }
    private void initPoints()
    {
       points = new ArrayList<>();
        double length=500;
        var a = new Vector2D(20,150);
        var b = new Vector2D(a.getX()+length,a.getY());
        var c = new Vector2D(a);
        var direction = new Vector2D(a,b);
        direction.rotate(Math.PI/3);
        c.add(direction);
        points.add(a);
        points.add(b);
        points.add(c);
        System.out.println(points);
        points.add(points.get(0));
    }
    public void paint(Graphics g)
    {
        super.paint(g);
       g.setColor(Color.white);
       Polygon polygon = new Polygon();
        for(Vector2D p : points)
            polygonAddVector(polygon, p);
        g.drawPolygon(polygon);
    }
    private void polygonAddVector(Polygon p, Vector2D v)
    {
        p.addPoint((int)v.getX(), (int)v.getY());
    }
    public void test()
    {
       Timer t = new Timer(1000,(e)->{
           ArrayList<Vector2D> newpoints = new ArrayList<Vector2D>();
           if(points.size()>10000)
           {
               System.out.println(points.size() + " Punkte sind genug -> Neustart");
               initPoints();
               paint(getGraphics());
               return;
           }
           for(int i=0;i<points.size()-1;i++)
           {
               Vector2D oldpoint = points.get(i);
               newpoints.add(oldpoint);
               Vector2D b = new Vector2D(oldpoint);
               Vector2D direction = new Vector2D(oldpoint, points.get(i+1));
               direction.scale(1/3.0);
               b.add(direction);
               newpoints.add(b);
               var c=new Vector2D(b);
               direction.rotate(-Math.PI/3);
               c.add(direction);
               newpoints.add(c);
               var d = new Vector2D(c);
               direction.rotate(2*Math.PI/3);
               d.add(direction);
               newpoints.add(d);
               //System.out.println(newpoints);
           }
           newpoints.add(points.get(0));
           points = newpoints;
           paint(getGraphics());
       });
       t.start();
    }

}
