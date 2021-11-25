package trial;
import java.io.IOException;
import java.util.Scanner;
public class SlidingObjects extends Object implements Driver{
	private double length;
	private double height;
	public SlidingObjects(Object obj,int choice,int subchoice) {
		super(obj);
		length=0;
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
	public void simulate(int choice,int subchoice,Scanner input, SlidingObjects so2) throws Exception, IOException
	{
		
		double x1,v1,mu,g,x2,v2,v1f,v2f,vcm,m1,m2,e;
		double ts = input.nextDouble();
		input.nextLine();
		double t = input.nextDouble();
		input.nextLine();
		x1=super.getCoordinates().getX();
		x2 = so2.getCoordinates().getX();
		v1 = this.getV();
		v2 = so2.getV();
		m1 = this.getWeight();
		m2 = so2.getWeight();
		e = this.getE();
		mu=super.getMu();
		g=super.getG();
		System.out.println("For Object 1");
		if((v2-v1)*(x2-x1) < 0)
		{
			double col_time = ((v1+v2)/(x2-x1));
			double temp=0;
			v1 = v1-mu*g*col_time;
			v2 = v2-mu*g*col_time;
			vcm = (m1*v1 + m2*v2)/(m1+m2);
			v1f = (1+e)*vcm -e*v1;
			if(t>col_time)
			{
				plane(subchoice,ts,col_time);
				this.setV(v1f);
				this.setA(0);
				plane(subchoice,ts, t-col_time);
			}
			else plane(subchoice,ts,t);
		}
		else
		{
			plane(subchoice,ts,t);
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
		System.out.println("the position after time "+t+" is ("+x+","+y+").");
	}
	
	
}

