package Core;

import java.util.ArrayList;
import java.util.Collections;

public class Generation {
	
	private ArrayList<Ball> units = new ArrayList<Ball>();
	private int updateCycle = 0;
	
	private int meanX=0;
	
	
	public Generation(){
		for(int i=0; i<100; i++){
			units.add(new Ball());
		}	
	}
	
	public Generation(ArrayList<Ball> newGen){
		units=newGen;
	}
	
	public void update(){
		int sumX= 0;
		//System.out.println("Life Cycle: "+updateCycle);
		for(Ball b : units){
			b.update(updateCycle);
			sumX+=b.getX();
		}
		meanX=sumX/units.size();
		updateCycle++;
	}
	
	public int getCycles(){ return updateCycle; }
	
	public ArrayList<Ball> getSortedUnits(){
		Collections.sort(units);
		return units;
	}
	
	public ArrayList<Ball> getUnits(){
		return units;
	}
	
	public void punctuateUnits(){
		for(Ball u : units){
			u.setPoints(u.getX());
		}
	}
	
	public int getMeanX(){
		return meanX;
	}

}
