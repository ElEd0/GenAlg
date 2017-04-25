package Core;

public class Ball implements Comparable<Ball> {
	
	private int x, y;
	private int points;
	
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
		for(int i=0; i<dnaM.length/2; i++){
			dna[i]=dnaM[i];
		}
		for(int i=dnaM.length/2; i<dnaP.length; i++){
			dna[i]=dnaP[i];
		}
		
	}
	
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

	@Override
	public int compareTo(Ball o) {
		return points-o.getPoints();
	}

}
