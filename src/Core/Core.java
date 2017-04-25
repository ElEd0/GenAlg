package Core;

public class Core {
	
	private Renderer renderer;
	

	public Core(){
		
		renderer = new Renderer();
		
		
		while(true){
			update();
		}
		
	}
	
	public void update(){
		renderer.render();
		
	}

}
