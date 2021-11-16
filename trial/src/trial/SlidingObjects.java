package trial;


public class SlidingObjects extends Object implements Driver{
	private double length;
	private double width;
	private double height;
	public SlidingObjects(Ground ground, int objectid, double weight, double v, Coordinates coordinates, double a,
			double length, double width, double height) {
		super(ground,objectid, weight, v, coordinates, a);
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public SlidingObjects(Ground ground, double weight, double v, double a,Coordinates coordinates) {
		super(ground,0,weight,v,coordinates,a);
	}
	
	
}

