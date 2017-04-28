package Core;

import java.util.ArrayList;
import java.util.TreeSet;

public class Urn {
	
	private ArrayList<Integer> papelets = new ArrayList<Integer>();
	
	public Urn(ArrayList<Ball> balls){
		for(int i=0; i<balls.size(); i++){
			for(int j=0; j<balls.get(i).getPoints()/10; j++){
				papelets.add(i);
			}
		}
	}
	
	/**
	 * Gets 2 random papelets and removes them from the Urn
	 * @return int array containing index of both parents
	 */
	public int[] getRandomParents(){
		int[] parents = new int[2];
		
		int mIndex = (int)(Math.random()*papelets.size());
		parents[0]=papelets.get(mIndex);
		papelets.remove(mIndex);
		
		ArrayList<Integer> tempPapelets = papelets;
		
		for(int i=0; i<tempPapelets.size(); i++){
			if(tempPapelets.get(i)==parents[0]){
				tempPapelets.remove(i);
			}
		}
		int pIndex = (int)(Math.random()*tempPapelets.size());
		parents[1]=tempPapelets.get(pIndex);
		
		for(int i=0; i<papelets.size(); i++){
			if(papelets.get(i)==parents[1]){
				papelets.remove(i);
				break;
			}
		}
		
		return parents;
	}

}
