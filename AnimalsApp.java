import java.awt.Point;
import java.util.ArrayList;

public class AnimalsApp implements Runnable{
	
	static boolean running = true;
	//PlantEater cow;
	MeatEater lion;
	public ArrayList<PlantEater> cows;
	
	public static void main(String[] args){

		System.out.println("Test Output.");
		
		(new Thread(new AnimalsApp())).start();
		
	}
	
	public void run() {
		
		int FRAMES_PER_SECOND = 25;
	    int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	    long next_game_tick = System.currentTimeMillis();
	    long sleep_time = 0;
	    
	    createAnimals();

	    while(running){

	        updateGame();
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
				
		lion = new MeatEater(100, 50, 15, 35, 1, 50, 50, this);
		
		
		//add multiple cows
		PlantEater c;
		
		cows = new ArrayList<PlantEater>();
		
		Point[] points = new Point[] {
				new Point(10, 10),
				new Point(20, 20),
				new Point(30, 30)
		};
		
		for(int i = 0; i < points.length; i++) {
			c = new PlantEater(100, 10, 5, 1, 1, 0, 0);
			c.setX(points[i].x);
			c.setY(points[i].y);
			cows.add(c);
		}
	}
	
	public ArrayList<PlantEater> getFoodItems(){
		return cows;
	}
}
