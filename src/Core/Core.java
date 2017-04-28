package Core;

import java.util.ArrayList;

public class Core {
	
	private Renderer renderer;
	private Generation currentGeneration, lastGeneration;
	private Urn urn;
	
	private int generations = 1;
	
	private long timer = System.currentTimeMillis();
	

	public Core(){
		
		currentGeneration = new Generation();
		renderer = new Renderer(currentGeneration);
		
		
		while(true){
			if(System.currentTimeMillis()-timer>5){
				update();
				timer=System.currentTimeMillis();
			}
		}
		
	}
	
	public void update(){
		renderer.render();
		currentGeneration.update();
		if(currentGeneration.getCycles()==99){
			changeGen();
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
			newGen.add(lastGeneration.getSortedUnits().get(i));
		}
		currentGeneration = new Generation(newGen);
		generations++;
		System.out.println("New Generation: "+generations);
	}

}
