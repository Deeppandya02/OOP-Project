package trial;
import java.io.*;
import java.lang.String;

class Main{
		static int counter=1;
		public static void main(String[] args) throws IOException{//IO exception for buffered reader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			outerloop:	
			while(counter!=0) {//asks user to keep choosing option until user exits the simulation
					if(counter>1)
					br.readLine();
					System.out.print("\033[H\033[2J");  
				    System.out.flush(); 
				    counter++;
				    System.out.println("\t\t\tSPRING, ACTION AND FORCES SIMULATOR");
				    System.out.println("what would you like to do?");
				    System.out.println("1.Slide \n2.Roll \n3.Collide \n4.Pendulum \n5.Spring \n6.String \n7.Exit");
				    System.out.println("Enter Your Choice: ");
				
		    		int choice=0;
		    		
		    		choice=Integer.parseInt(br.readLine());
					switch(choice) {
						case 1:System.out.println("slide");
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
						default:System.out.println("Please choose a valid option");
								break;
					}
					
				}
	} 
}

