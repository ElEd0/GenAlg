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
	
	public Renderer(Generation curr) {
		this.currGen=curr;

		frame = new JFrame("Gen_Alg");
		canvas = new JPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(640, 480);
		
		frame.getContentPane().add(canvas);
		
		g = canvas.getGraphics();
	}
	
	public void render(){
		canvas.setBackground(Color.GRAY);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 640, 480);
		g.setColor(Color.RED);
		for(Ball b : currGen.getUnits()){
			g.fillOval(b.getX(), b.getY(), 5, 5);
		}
		
	}

}
