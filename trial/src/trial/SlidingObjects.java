package trial;
import java.io.IOException;
import java.util.Scanner;
public class SlidingObjects extends Object implements Driver{
	private double length;
	private double width;
	private double height;
	public SlidingObjects(Object obj,int choice,int subchoice) {
		super(obj);
		length=0;
		width=0;
		height=0;
	}
	public void simulate(int choice,int subchoice,Scanner input) throws Exception, IOException {
		System.out.println("Enter the timeslice and total time respectively : ");
		//Scanner input=new Scanner(System.in);
		double ts = input.nextDouble();
		input.nextLine();
		double t = input.nextDouble();
		input.nextLine();
		if(subchoice==1) {
			plane(subchoice,ts,t);
		}
		else {
			System.out.println("in the making");
		}
	}
	public void plane(int subchoice,double ts, double t) {
		double a,v,x,y,mu,g,xAtTime;
		x=super.getCoordinates().getX();
		y=super.getCoordinates().getY();
		mu=super.getMu();
		v=super.getV();
		a =super.getA();
		g=super.getG();
		if(a<mu*g)
		{
			double stoppingtime = -v/(-mu*g+a);
			for(double i=0.0 ;i<t&&i<stoppingtime;i+=ts ) {
				xAtTime=v*i+0.5*(a-mu*g)*i*i+x;
				System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+y+").");
				}
				xAtTime=v*stoppingtime+0.5*(a-mu*g)*stoppingtime*stoppingtime+x;
				if(stoppingtime>=t)
					x=v*t+0.5*(a-mu*g)*t*t+x;
				else
					x=xAtTime;
				System.out.println("Object comes to rest after "+stoppingtime+" seconds and at coordinates (" +xAtTime+ ","+y+").");
				
		}
		if(a>mu*g) {
			for(double i=0.0 ;i<t;i+=ts ) {
				xAtTime=v*i+0.5*(a-mu*g)*i*i+x;
				System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+y+").");
				}
				x=v*t+0.5*(a-mu*g)*t*t+x;
		}
			
		super.getCoordinates().setX(x);
		System.out.println("the final position after time "+t+" is ("+x+","+y+").");
	}
	
	
}

