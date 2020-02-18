import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimalsApp extends JPanel implements Runnable{
	
	static boolean running = true;
	//PlantEater cow;
	MeatEater lion;
	public ArrayList<PlantEater> cows;
	static AnimalsApp animalsApp = new AnimalsApp();
	
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("Animals App");
		frame.getContentPane().add(animalsApp);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		System.out.println("Test Output.");
		
		(new Thread(animalsApp)).start();
				
	}
	
	public void run() {
		
		int FRAMES_PER_SECOND = 25;
	    int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	    long next_game_tick = System.currentTimeMillis();
	    long sleep_time = 0;
	    
	    createAnimals();

	    while(running){

	        updateGame();
	        repaint();
	        
	       // System.out.println("game updated");
	        next_game_tick = SKIP_TICKS;
	        sleep_time = 1000; //next_game_tick - System.currentTimeMillis();

	        if(sleep_time > 0){

	            try {

	                Thread.sleep(sleep_time);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	private void updateGame() {
		for(int i = 0; i < cows.size(); i++) {
			cows.get(i).update();
			System.out.println("Cow: " + cows.get(i).getX()  + " " + cows.get(i).getY());
		}
		
		lion.update();
		System.out.println("Lion: " + lion.getX() + " " + lion.getY());
		
		for(int i = 0; i < cows.size(); i++) {
			if(cows.get(i).getX() == lion.getX() && cows.get(i).getY() == lion.getY()) {
				running = false;
			}
		}
	}
	
	private void createAnimals() {
		
		//cow = new PlantEater(100, 10, 5, 1, 1, 10, 10);
				
		lion = new MeatEater(100, 50, 15, 35, 1, 150, 150, this);
		
		
		//add multiple cows
		PlantEater c;
		
		cows = new ArrayList<PlantEater>();
		
		Point[] points = new Point[] {
				new Point(10, 10),
				new Point(200, 200),
				new Point(300, 300),
				new Point(150, 30)
		};
		
		for(int i = 0; i < points.length; i++) {
			c = new PlantEater(100, 10, 10, 1, 1, 0, 0, this);
			c.setX(points[i].x);
			c.setY(points[i].y);
			cows.add(c);
		}
	}
	
	public ArrayList<PlantEater> getFoodItems(){
		return cows;
	}
	
	public MeatEater getLion() {
		return lion;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		final java.awt.Color colorBlue = java.awt.Color.BLUE;
		final java.awt.Color colorRed = java.awt.Color.RED;
				
			g.setColor(colorBlue);
			g.fillOval(lion.getX(), lion.getY(), 5, 5);
			
			for(int i = 0; i < cows.size(); i++) {
				g.setColor(colorRed);
				g.fillOval(cows.get(i).getX(), cows.get(i).getY(), 5, 5);
			}
			
	}
	
	
}
