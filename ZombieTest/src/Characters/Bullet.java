package Characters;
 public class Bullet {
 	private double x, y, a; //x y and angle
 	private int w,h; //width and height
 	public Bullet (double a, double x, double y, int w, int h)
 	{
 		this.a = a;
 		this.x = x;
 		this.y = y;
 		this.w = w;
 		this.h = h;
 	}
 	public double getX()
 	{
		return x;
 	}	
 	public double getY()
 	{
 		return y;
 	}
 	public double getA()
 	{
 		return a;
 	}
 	public int getW()
 	{
 		return w;
 	}
 	public int getH()
 	{
 		return h;
 	}
 	public void setA(double aa) 
	{
 		this.a = aa;
 	}
 	public void setX(double x) 
 	{
 	    this.x = x;
 	}
 	public void setY(double y) 
 	{
 	    this.y = y;
 	}
 	public void setW(int w) 
 	{
 	    this.w = w;
 	}
 	public void setH(int h) 
 	{
	    this.h = h;
 	}
 	//moves forwards to the angle
 	public void moveForward(int speed) 
 	{
 	    x += Math.cos(a)*speed;
 	    y += Math.sin(a)*speed;
	}
 }