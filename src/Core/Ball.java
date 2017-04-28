package Core;

public class Ball implements Comparable<Ball> {
	
	private int x=10, y=100;
	private int points=0;
	
	private int[][] dna = new int[100][2];
	
	public Ball(){
		for(int i=0; i< dna.length; i++){
			int dir = (int)(Math.random()*4);
			int meters = (int)(Math.random()*10);
			dna[i][0]=dir;
			dna[i][1]=meters;
		}
	}
	
	public Ball(int[][] dnaM, int[][] dnaP){
		
		for(int i=0; i<dna.length; i++){
			if((int)(Math.random()*2)==1)
				dna[i]=dnaM[i];
			else
				dna[i]=dnaP[i];
		}
		
	}
	
	public void update(int lifeCycle){
		switch(dna[lifeCycle][0]){
		case 0: y+=dna[lifeCycle][1]; break;
		case 1: x-=dna[lifeCycle][1]; break;
		case 2: y-=dna[lifeCycle][1]; break;
		case 3: x+=dna[lifeCycle][1]; break;
		default: System.err.println("CRITICAL ERROR");
		}
	}
	
	public int[][] getDna(){ return dna; }
	
	public int getMetersAtIndex(int i){
		return dna[i][1];
	}
	
	public int getDirectionAtIndex(int i){
		return dna[i][0];
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getPoints(){ return points; }
	
	public void setPoints(int points){ this.points=points; }

	@Override
	public int compareTo(Ball o) {
		return o.getPoints()-points;
	}

}
