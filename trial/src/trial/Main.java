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
								Object obj = new Object(fillObject(choice,choice1,ground));
								SlidingObjects so = new SlidingObjects(fillSO(obj,choice,choice1),choice,choice1);
								so.simulate(choice,choice1,input);
								//System.out.println("Enter time intervals and total time at which you have to find coordinates");
								//double ts = input.nextDouble();
								//input.nextLine();
								//double t = input.nextDouble();
								//input.nextLine();
								//so.plane(choice1, ts, t);
								break;
						case 2:System.out.println("roll");
								
								break;
						case 3:System.out.println("collide");
								break;
						case 4:System.out.println("pendulum");
								break;
						case 5: System.out.println("spring");
								break;
						case 6:System.out.println("string");
								break;
						case 7: System.out.println("toppling from external force");
								break;
						case 8: System.out.println("Exiting the Menu...");
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
			return obj;
		}
		public static SlidingObjects fillSO(Object obj,int choice,int subchoice) throws Exception {
			SlidingObjects so = new SlidingObjects(obj,choice,subchoice);
			return so;
		}
}

