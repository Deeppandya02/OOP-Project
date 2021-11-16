package trial;

public class Object extends Ground{
	private int objectid;
	private double weight;
	private double v;
	private Coordinates coordinates;
	private double a;
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public int getObjectid() {
		return objectid;
	}
	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getV() {
		return v;
	}
	public void setV(double v) {
		this.v = v;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public Object(Ground ground, int objectid, double weight, double v, Coordinates coordinates, double a) {
		super(ground);
		this.objectid = objectid;
		this.weight = weight;
		this.v = v;
		this.coordinates = coordinates;
		this.a = a;
	}
	
}
