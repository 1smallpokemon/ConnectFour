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
	public static JPanel panel;
	public static final Dimension SCREEN_SIZE = new Dimension(800,600);
	public static final Dimension GAME_SIZE = new Dimension(400,300);
	public static final String title = "Connect Four";
	
	public Image screen;
	
	private int x=0,y=0;
	
	
	public static boolean isRunning = true	;
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.setSize(SCREEN_SIZE);
		frame.setTitle(title);
		
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("Start");
		panel.add(button);
		
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
		g.setColor(Color.GREEN);
		g.fillRect(x,y,x+100,y+100);
		
		x++;y++;
		
		g = getGraphics();
		g.drawImage(screen, 0,0,SCREEN_SIZE.width,SCREEN_SIZE.height,0,0,GAME_SIZE.width,GAME_SIZE.height,null);
		
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

