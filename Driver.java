package trial;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public interface Driver {
	default Coordinates getCoordinates(Object o) {
		return o.getCoordinates(); 
	}
	default Coordinates slide(SlidingObjects obj) {
		 
		return obj.getCoordinates();
	}
	void simulate(int a,int b,Scanner s) throws IOException, Exception;
}



