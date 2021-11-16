package trial;

public interface Driver {
	default Coordinates getCoordinates(Object o) {
		return o.getCoordinates(); 
	}
	default Coordinates slide(SlidingObjects obj) {
		 
		return obj.getCoordinates();
	}	
	
	
}

