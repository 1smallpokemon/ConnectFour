package test;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class Main extends Applet implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JFrame frame;
	public static final Dimension SCREEN_SIZE = new Dimension(800,600);
	public static final Dimension GAME_SIZE = new Dimension(400,300);
	public static final String title = "Connect Four";
	
	public Image screen;
	
	
	public static boolean isRunning;
	
	public static void main(String[] args) {
		
		Main main = new Main();
		frame.setSize(SCREEN_SIZE);
		frame.setTitle(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(main);
		frame.pack();
		frame.setVisible(true);
		main.start();
	}
	
	public Main() {
		
		setPreferredSize(SCREEN_SIZE);
		frame = new JFrame();
		

	}
	
	public void init() {
		
		screen = createVolatileImage(GAME_SIZE.width, GAME_SIZE.height);
		
	}
	public void start() {
		init();
		new Thread(this).start();
		
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		Graphics g = screen.getGraphics();
		g.setColor(new Color(Color.GREEN));
		g.fillRect(0,0,100,100);
		
		g = frame.getGraphics()
		g.drawImage(screen, 0,0,800,600,0,0,400,300,null);
		
		g.dispose();
		
	}
	
	public void run() {
		init();
		while(isRunning) {
			tick();
			render();
			try {Thread.sleep(50);}
			catch (InterruptedException ie) {}
			
		}
	}
	
	public void stop() {
		isRunning = false;
	}
	
	
}

