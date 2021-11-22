package trial;

public class Driver {
	private double theta;
	private double g;
	private double mu;
	private double e;
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter angle of inclination of Slope");
	theta = sc.nextDouble();
	
	System.out.println("Enter acceleration due to gravity");
	g = sc.nextDouble();
	
	System.out.println("Enter coefficient of friction");
	mu = sc.nextDouble();
	
	System.out.println("Enter coefficient of Restitution");
	e = sc.nextDouble();
	
	Slope slope = new slope(theta,g,mu,e);
	int n;
	sc.nextInt();
	Object[] objs = new Object[n];
	for(int i = 0; i < n; i++)
	{
		String objID;
		String objTypeID;
		//Print obj type id for each type
		System.out.println("Enter ObjID");
		objID = sc.nextLine();
		System.out.println("Enter ObjTypeID");
		objTypeID = sc.nextLine();
		System.out.println("Enter intial coordinates of object");
		double x,y;
		x = sc.nextDouble();
		y = sc.nextDouble();
		//Orientation;
		Object obj[i];
		switch(objTypeID)
		{
			case 0: 
				obj[i] = new Box();
				System.out.println("Enter length");
				double length = sc.nextDouble();
				System.out.println("Enter width");
				double width = sc.nextDouble();
				System.out.println("Enter height");
				double height = sc.nextDouble();
		
	}	
	
	
}

