package view;

import java.applet.Applet;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
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
	
	@SuppressWarnings("unused")
	private static Grid grid = new Grid();
	
	private int x=0,y=0;
	
	
	public static boolean isRunning = true	;
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		frame = new JFrame();
		frame.setTitle("Connect Four");
		frame.setBounds(100, 100, 799, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addPiece(frame.getMousePosition().getX(),frame.getMousePosition().getY());
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\CompSci\\Desktop\\Untitled.png"));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		
		
		
		frame.pack();
		frame.setVisible(true);
		main.start();
	}
	
	protected static void addPiece(double x2, double y2) {
		// TODO Auto-generated method stub
		x2 -= 50;
		x2 %= 100;
		
		grid.addPiece(new Double(x2).intValue());
		grid.printStatus();
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
	class ImagePanel extends JComponent {
	    private Image image;
	    public ImagePanel(Image image) {
	        this.image = image;
	    }
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	    }
	}

	
}

