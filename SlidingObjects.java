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
		double x1,y1,v1,mu,g,x2,v2,v1f,vcm,m1,m2,e,v2f,x1AtTime,t1,t2,x2AtTime;
		System.out.println("Enter the timeslice and total time respectively : ");
		double ts = input.nextDouble();
		input.nextLine();
		double t = input.nextDouble();
		input.nextLine();
		x1=super.getCoordinates().getX();
		y1=super.getCoordinates().getY();
		x2 = so2.getCoordinates().getX();
		v1 = this.getV();
		v2 = so2.getV();
		m1 = this.getWeight();
		m2 = so2.getWeight();
		e = this.getE();
		mu=super.getMu();
		g=super.getG();
		if(x2-x1 > 0 && v2 - v1 < 0)
		{
			double col_time = (x2-x1)/(v1-v2);
			t1 = v1/mu*g;
			if(v2>=0)
			{
				if(t1 <= col_time)
				{
					System.out.println("Objects will not collide");
				}
				else
				{
					for(double i = 0; i < t; i+=ts)
					{
						if(i < col_time)
						{
							x1AtTime = v1*i+0.5*((-1)*mu*g)*i*i+x1;
							x2AtTime = v2*i +0.5*(-1)*mu*g*i*i + x2;
							System.out.println("coordinates of the object1 after "+i+" seconds is ("+ x1AtTime + ","+y1+").");
							System.out.println("coordinates of the object2 after "+i+" seconds is ("+ x2AtTime + ","+y1+").");
						}
					}
					v1 = v1-mu*g*col_time;
					v2 = v2-mu*g*col_time;
					vcm = (m1*v1 + m2*v2)/(m1+m2);
					v1f = (1+e)*vcm -e*v1;
					v2f = (1+e)*vcm -e*v2;
					double xc1,xc2;
					System.out.println("Objects will collide at " +col_time+ "seconds");
					xc1 = v1*col_time+0.5*((-1)*mu*g)*col_time*col_time+x1;
					xc2 = v2*col_time+0.5*((-1)*mu*g)*col_time*col_time+x2;
					System.out.println("coordinates of the object1 after "+col_time+" seconds is ("+ xc1 + ","+y1+").");
					System.out.println("coordinates of the object2 after "+col_time+" seconds is ("+ xc2 + ","+y1+").");
					for(double i = col_time + ts; i < t; i+=ts)
					{
						double q = i-col_time;
						x1AtTime = xc1 + v1f*q -0.5*mu*g*q*q;
						x2AtTime = xc2 + v2f*q -0.5*mu*g*q*q;
						System.out.println("coordinates of the object1 after "+i+" seconds is ("+ x1AtTime + ","+y1+").");
						System.out.println("coordinates of the object2 after "+i+" seconds is ("+ x2AtTime + ","+y1+").");
					}
				}
			}
			
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

