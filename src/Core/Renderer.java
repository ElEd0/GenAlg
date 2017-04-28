package Core;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer {
	
	private JFrame frame;
	private JPanel canvas;
	
	private Graphics g;
	
	private Generation currGen;
	private int generations=1;
	
	public Renderer(Generation curr) {
		this.currGen=curr;

		frame = new JFrame("Gen_Alg");
		canvas = new JPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1280, 720);
		
		frame.getContentPane().add(canvas);
		
		g = canvas.getGraphics();
	}
	
	public void render(){
		canvas.setBackground(Color.GRAY);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1280, 720);
		g.setColor(Color.RED);
		for(Ball b : currGen.getUnits()){
			g.fillOval(b.getX(), b.getY(), 5, 5);
		}
		g.setColor(Color.BLUE);
		g.fillOval(200, 200, 5, 5);
		g.drawString("Generation: "+String.valueOf(generations), 0, 20);
		g.drawString("Mean xPos: "+currGen.getMeanX(), 0, 40);
		
	}
	
	public void updateGen(Generation currGen){
		this.currGen=currGen;
		generations++;
	}

}
