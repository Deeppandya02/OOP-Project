package trial;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;
public class RollingObjects extends Object implements Driver{
	private double r;	
	private double k;
	private double omega;
	public RollingObjects(Ground ground,int objectid, double weight, double v, Coordinates coordinates,double a,
			double radius, double k, double alpha, double omega) {
		super(ground, objectid, weight, v, coordinates, a);
		this.r = radius;
		this.k = k;
		this.omega = omega;
	}
	private void setomega(double nextDouble) {
		// TODO Auto-generated method stub
		this.omega = nextDouble;
	}
	public RollingObjects(Object obj, int choice, int subchoice) {
		// TODO Auto-generated constructor stub
		super(obj);
		
	}
	public void simulate(int choice,int subchoice,Scanner input) throws Exception, IOException {
		System.out.println("Please enter the type of object for simulation \n1. Cylinder 2. Sphere \n 3. Ring");
		int z = input.nextInt();
		input.nextLine();
		System.out.println("Please enter initial angular velocity:- ");
		this.setomega(input.nextDouble());
		input.nextLine();
		{
			System.out.println("Enter radius");
			this.r = input.nextDouble();
			input.nextLine();
			if(z == 1)
			{
				k = Math.sqrt(0.5)*r;
			}
			if(z==2)
			{
				k = Math.sqrt(1.4)*r;
			}
			else k = r;
		}
		System.out.println("Enter the timeslice and total time respectively : ");
		//Scanner input=new Scanner(System.in);
		double ts = input.nextDouble();
		input.nextLine();
		double t = input.nextDouble();
		input.nextLine();
		if(subchoice==1) {
			plane_roll(subchoice,ts,t);
		}
		else if(subchoice == 2)
		{
			slope_roll(subchoice,ts,t);
		}
		else {
			System.out.println("in the making");
		}
	}
	public void plane_roll(int subchoice,double ts, double t) {
		// TODO Auto-generated method stub
		int b = -1;
		double v,x,y,mu,g,xAtTime;
		x=super.getCoordinates().getX();
		y=super.getCoordinates().getY();
		mu=super.getMu();
		v=super.getV();
		g=super.getG();
		if(v>r*omega) b=1;
		double q = (v-r*omega)/(mu*g*(((r*r)/(k*k))+1));
		for(double i = 0.0; i < t; i+=ts)
		{
			if(v==r*omega)
			{
				xAtTime = x + v*i;
				System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+y+").");
			}
			else
			{
				if(i < q*b)
				{
					xAtTime = x + v*i - mu*g*i*i*(1/2)*b;
					System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+y+").");
//					v = v - b*mu*g*i;
//					omega = omega + b*mu*g*r*r*i/(k*k);
				}
				else
				{
					xAtTime = x + v*q*b - mu*g*q*q*(1/2)*b + (v - mu*g*q)*(i-q*b);
					System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+y+").");
//					v = v - mu*g*q;
//					omega = omega + mu*g*r*r*q/(k*k);
				}
			}
		}
		}
	public void slope_roll(int subchoice, double ts, double t)
	{
		double v,x,mu,g,xAtTime,yAtTime;
		x = super.getCoordinates().getX();
		mu=super.getMu();
		v=super.getV();
		g=super.getG();
		double q = 1 + (r*r)/(k*k);
		if(Math.tan(super.getTheta()) <= mu*q)
		{
			super.setA(g*Math.sin(super.getTheta())/q);
			double a = super.getA();
			for(double i = 0.0; i < t; i+=ts)
			{
				xAtTime=v*i+0.5*(a)*i*i+x;
				yAtTime = xAtTime*Math.tan(super.getTheta());
				System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+yAtTime+").");
			}
		}
		else
		{
			super.setA(g*Math.sin(super.getTheta()) - mu*g*Math.cos(super.getTheta()));
			double a = super.getA();
			for(double i = 0.0; i < t; i+=ts)
			{
				xAtTime=v*i+0.5*(a)*i*i+x;
				yAtTime = xAtTime*Math.tan(super.getTheta());
				System.out.println("coordinates of the object after "+i+" seconds is ("+ xAtTime + ","+yAtTime+").");
			}
		}
	}
	
}
