package trial;
import java.io.*;
import java.util.*;
public class Main{
		static int counter=0;
		static Scanner input;
		static int choice=0;
		public static void main(String[] args) throws Exception{//IO exception for buffered reader
			
			input = new Scanner(System.in);
			outerloop:	
			while(counter>=0) {//asks user to keep choosing option until user exits the simulation
					if(counter>=1) {
						System.out.println("Press enter to proceed to Menu");
						input.nextLine();
					} 
				    counter++;
				    System.out.println("\t\t\tSPRING, ACTION AND FORCES SIMULATOR");
				    System.out.println("what would you like to do?");
				    System.out.println("1.Slide \n2.Roll \n3.Collide \n4.Pendulum \n5.Spring \n6.String \n7.Toppling from external Force\n8.Exit");
				    System.out.println("Enter Your Choice: ");
		    		choice=input.nextInt();
		    		input.nextLine();
		    	    
					switch(choice) {
						case 1:	int choice1=subchoice(choice);
								Ground ground = new Ground(fillground(choice,choice1));
								Object obj1 = new Object(fillObject(choice,choice1,ground));
								SlidingObjects so = new SlidingObjects(fillSO(obj1,choice,choice1),choice,choice1);
								so.simulate(choice,choice1,input);
								//System.out.println("Enter time intervals and total time at which you have to find coordinates");
								//double ts = input.nextDouble();
								//input.nextLine();
								//double t = input.nextDouble();
								//input.nextLine();
								//so.plane(choice1, ts, t);
								break;
						case 2:
								int choice2 = subchoice(choice);
								Ground ground1 = new Ground(fillground(choice,choice2));
								Object obj2 = new Object(fillObject(choice,choice2,ground1));
								RollingObjects ro = new RollingObjects(obj2,choice,choice2);
								ro.simulate(choice,choice2,input);
								break;
						case 3://System.out.println("collide");
								int choice3 = subchoice(choice);
								Ground ground11 = new Ground(fillground(choice,choice3));
								Object obj11 = new Object(fillObject(choice,choice3,ground11));
								SlidingObjects so1 = new SlidingObjects(fillSO(obj11,choice,choice3),choice,choice3);
								Object obj21 = new Object(fillObject(choice,choice3,ground11));
								SlidingObjects so2= new SlidingObjects(fillSO(obj21,choice,choice3),choice,choice3);
								so1.simulate(choice, choice3, input,so2);
								so2.simulate(choice, choice3, input,so1);
								break;
						case 4: System.out.println("spring");
								break;
						case 5:System.out.println("string");
								int choice4 = subchoice(choice);
								Ground ground111 = new Ground(fillground(choice,choice4));
								Object obj111 = new Object(fillObject(choice,choice4,ground111));
								SlidingObjects so11 = new SlidingObjects(fillSO(obj111,choice,choice4),choice,choice4);
								Object obj3 = new Object(fillObject(choice,choice4,ground111));
								SlidingObjects so21 = new SlidingObjects(fillSO(obj3,choice,choice4),choice,choice4);
								Strings strings = new Strings(so11,so21);
								strings.simulate(choice, choice4, input);
								break;
						case 6: System.out.println("toppling from external force");
								break;
						case 7: System.out.println("Exiting the Menu...");
						        break outerloop; 
						default:System.out.println("Please choose a valid entry format");
								break;
					}
					
				}
			if(choice==8)
			input.close();
	} 
		public static int subchoice(int choice) throws Exception {
			
			
			if(choice==1) {
				System.out.println("please choose a simulation to perform \n1.Object sliding on plane surface \n2.object doing projectile motion \n3.object on slope");
				int choice1=input.nextInt();
				input.nextLine();
				return choice1;
			}
			if(choice == 2)
			{
				System.out.println("please choose a simulation to perform \n1.Object rolling on plane surface \n2.object rollin on slope");
				int choice1=input.nextInt();
				input.nextLine();
				return choice1;
			}
			if(choice == 3)
			{
				int choice1=1;
				return choice1;
			}
			if(choice==5)
			{
				int choice1=1;
				return choice1;
			}
			return 0;
			
		}
		public static Ground fillground(int choice,int choice1) throws Exception,IOException { 
			
			double mu=0,theta=0,e=0;
			if(choice1==1&&choice==1) {
				System.out.println("Please enter the values of Coefficient of friction ");
				mu=input.nextDouble();
				input.nextLine();
				Ground ground = new Ground(theta,mu,e);
				return ground;
			}
			if(choice1==2&&choice==1) {
				System.out.println("please enter the values of angle of Projection (in Degrees) and Coefficient Of Restitution");
				//BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
				theta=Math.toRadians(input.nextDouble());
				input.nextLine();
				e=input.nextDouble();
				input.nextLine();
				Ground ground = new Ground(theta,mu,e);
				return ground;
			}
			if(choice1==3&&choice==1) {
				System.out.println("please enter the value of slope of the inclined plane and coefficient Of restitution");
				theta=Math.toRadians(input.nextDouble());
				input.nextLine();
				e=input.nextDouble();
				input.nextLine();
				Ground ground = new Ground(theta,mu,e);
				return ground;
			}
			if(choice1==1 && choice ==2)
			{
				System.out.println("Please enter the values of Coefficient of friction ");
				mu=input.nextDouble();
				input.nextLine();
				Ground ground = new Ground(theta,mu,e);
				return ground;
			}
			if(choice1==2 && choice == 2)
			{
				System.out.println("please enter the value of slope of the inclined plane");
				theta=Math.toRadians(input.nextDouble());
				input.nextLine();
				Ground ground = new Ground(theta,mu,e);
				return ground;
			}
			if(choice==3)
			{
				if(choice1 == 1)
				{
					System.out.println("Please enter the values of Coefficient of friction ");
					mu=input.nextDouble();
					System.out.println("Please enter the values of Coefficient of restitution ");
					e=input.nextDouble();
					input.nextLine();
					Ground ground = new Ground(theta,mu,e);
					return ground;
				}
			}
			if(choice==5)
			{
				Ground ground = new Ground(theta,mu,e);
				return ground;
			}
			return null;
		}
		public static Object fillObject(int choice,int subchoice,Ground ground) throws Exception{
			System.out.println("please enter initial coordinates X and Y respectively");
			double x = input.nextDouble();
			double y=0;
			input.nextLine();
			if(subchoice==3&&choice==1) {
				y= x*Math.tan(ground.getTheta()); 
			}else {
				y=input.nextDouble();
				input.nextLine();
			}
			Coordinates coordinates = new Coordinates(x,y);
			Object obj = new Object(ground,coordinates);
			if((subchoice==1||subchoice==2)&&choice==1) {
				System.out.println("Please enter initial velocity:- ");
				obj.setV(input.nextDouble());
			    input.nextLine();
			}
			if(subchoice==1&&choice==1) {
				System.out.println("Please enter initial acceleration:- ");
				obj.setA(input.nextDouble());
				input.nextLine();
			}
			if(choice == 2)
			{
				System.out.println("Please enter initial velocity:- ");
				obj.setV(input.nextDouble());
				input.nextLine();
				if(subchoice == 2)
				{
					y= x*Math.tan(ground.getTheta());
				}
			}
			if(choice == 3)
			{
				System.out.println("Please enter initial velocity:- ");
				obj.setV(input.nextDouble());
				input.nextLine();
			}
			if(choice==5)
			{
				System.out.println("Please enter mass of object");
			}
			return obj;
		}
		public static SlidingObjects fillSO(Object obj,int choice,int subchoice) throws Exception {
			SlidingObjects so = new SlidingObjects(obj,choice,subchoice);
			return so;
		}
		public static RollingObjects fillRO(Object obj,int choice,int subchoice) throws Exception {
			RollingObjects ro = new RollingObjects(obj,choice,subchoice);
			return ro;
		}
		
}

