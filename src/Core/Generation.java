package Core;

import java.util.TreeSet;

public class Generation {
	
	private TreeSet<Ball> units = new TreeSet<Ball>();
	
	
	public Generation(){
		for(int i=0; i<100; i++){
			units.add(new Ball());
		}
		
	}
	
	public Generation(Ball[] parents){
		
	}

}
