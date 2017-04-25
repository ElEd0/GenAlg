package Core;

import java.util.ArrayList;

public class Urn {
	
	private ArrayList<Integer> papelets = new ArrayList<Integer>();
	
	public Urn(Ball[] balls){
		for(int i=0; i<balls.length; i++){
			for(int j=0; j<balls[i].getPoints()/10; j++){
				papelets.add(i);
			}
		}
	}
	
	
	public int[] getParents(){
		int[] parents = new int[2];
		int mIndex = (int)(Math.random()*papelets.size());
		parents[0]=papelets.get(mIndex);
		ArrayList<Integer> tempPapelets = papelets;
		for(int i=0; i<tempPapelets.size(); i++){
			if(tempPapelets.get(i)==parents[0]){
				tempPapelets.remove(i);
			}
		}
		int pIndex = (int)(Math.random()*tempPapelets.size());
		parents[1]=tempPapelets.get(pIndex);
		
		return parents;
	}

}
