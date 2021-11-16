package trial;
public class RollingObjects extends Object implements Driver{
	private double radius;	
	private double radiusOfGyration;
	private double alpha;
	private double omega;
	public RollingObjects(Ground ground,int objectid, double weight, double v, Coordinates coordinates,double a,
			double radius, double radiusOfGyration, double alpha, double omega) {
		super(ground, objectid, weight, v, coordinates, a);
		this.radius = radius;
		this.radiusOfGyration = radiusOfGyration;
		this.alpha = alpha;
		this.omega = omega;
	}
	
}
