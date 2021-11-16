package trial;


public class Ground {
	private double theta;
	private double g;
	private double mu;
	private double e;
	
	public double getTheta() {
		return theta;
	}

	public double getG() {
		return g;
	}

	public double getMu() {
		return mu;
	}

	public double getE() {
		return e;
	}
	
	public Ground(double theta, double g, double mu, double e) {
		this.theta = theta;
		this.g = g;
		this.mu = mu;
		this.e = e;
	}
	
	public Ground(Ground ground) {
		// TODO Auto-generated constructor stub
		this(ground.theta, ground.g, ground.mu, ground.e);
	}
}