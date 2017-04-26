package Core;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer {
	
	private JFrame frame;
	private JPanel canvas;
	
	private Graphics g;
	
	public Renderer() {

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
		g.setColor(Color.RED);
		g.fillOval(100, 100, 100, 100);
		
	}

}
