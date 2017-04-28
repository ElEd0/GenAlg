package Core;

import java.util.ArrayList;

public class Core {
	
	private Renderer renderer;
	private Generation currentGeneration, lastGeneration;
	private Urn urn;
	
	private int generations = 1;
	
	private long timer = System.currentTimeMillis();
	private long renderTimer = System.currentTimeMillis();
	

	public Core(){
		
		currentGeneration = new Generation();
		renderer = new Renderer(currentGeneration);
		System.out.println("dir0: "+Ball.c0);
		System.out.println("dir1: "+Ball.c1);
		System.out.println("dir2: "+Ball.c2);
		System.out.println("dir3: "+Ball.c3);
		
		
		while(true){
			if(System.currentTimeMillis()-timer>20){
				update();
				timer=System.currentTimeMillis();
			}
		}
		
	}
	
	public void update(){
		currentGeneration.update();
		if(currentGeneration.getCycles()==999){
			changeGen();
		}
		if(System.currentTimeMillis()-renderTimer>1000){
			renderer.render();
			renderTimer=System.currentTimeMillis();
		}
		
	}
	
	public void changeGen(){
		currentGeneration.punctuateUnits();
		urn=new Urn(currentGeneration.getSortedUnits());
		lastGeneration=currentGeneration;
		ArrayList<Ball> newGen = new ArrayList<Ball>();
		for(int i=0; i<50; i++){
			int[] parentsIndex = urn.getRandomParents();
			newGen.add(new Ball(lastGeneration.getSortedUnits().get(parentsIndex[0]).getDna(),
					lastGeneration.getSortedUnits().get(parentsIndex[1]).getDna()));
			newGen.add(new Ball(lastGeneration.getSortedUnits().get(i).getDna()));
		}
		currentGeneration = new Generation(newGen);
		generations++;
		System.out.println("New Generation: "+generations);
		renderer.updateGen(currentGeneration);
	}

}
