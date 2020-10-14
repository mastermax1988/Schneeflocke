package kochkurve;

public class Vector2D
{
    private double x,y;
    public Vector2D(double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    public Vector2D(Vector2D v)
    {
        x=v.getX();
        y=v.getY();
    }
    public Vector2D(Vector2D v1, Vector2D v2)
    {
        this(v1.getX(), v1.getY(), v2.getX(), v2.getY());
    }
    public Vector2D(double x1, double y1, double x2, double y2)
    {
        this(x2-x1,y2-y1);
    }
    public void scale(double s)
    {
        x*=s;
        y*=s;
    }
    public void rotate(double angle)
    {
        double x2=  x*Math.cos(angle)-y*Math.sin(angle);
        double y2 = x*Math.sin(angle) + y*Math.cos(angle);
        x=x2;
        y=y2;
    }
    public void add(Vector2D v)
    {
        x+=v.getX();
        y+=v.getY();
    }
    public double getX()
    {
        return x;
    }
       public double getY()
    {
        return y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }
    public String toString()
    {
        return "x: " + x + " y:" + y;
    }
}
