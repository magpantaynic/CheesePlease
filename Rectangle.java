/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle
{
	// (x,y) represents top-left corner of Rectangle
	double x;
	double y;
	double width;
	double height;
	public Rectangle()
	{
    	this.setPosition(0, 0);
    	this.setSize(1, 1);
	}
	public Rectangle(double x, double y, double w, double h)
	{
    	this.setPosition(x, y);
    	this.setSize(w, h);
	}
	public void setPosition(double x, double y)
	{
    	this.x = x;
    	this.y = y;
	}
	public void setSize(double w, double h)
	{
    	this.width = w;
    	this.height = h;
	}
	public boolean overlaps(Rectangle other)
	{
    	// Four cases where these is no overlap:
    	// 1: this to the left of other
    	// 2: this to the right of other
    	// 3: this is above other
    	// 4: other is above this
    	boolean noOverlap = this.x + this.width < other.x ||
            	other.x + other.width < this.x ||
            	this.y + this.height < other.y ||
            	other.y + other.height < this.y;
    	return !noOverlap;
	}
}
