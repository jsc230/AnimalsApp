import java.util.ArrayList;

public class MeatEater extends Animal {
	
	private int cowToEat;
	AnimalsApp animals = new AnimalsApp();
	public ArrayList<PlantEater> food = animals.getFoodItems();
	
	public MeatEater() {
		super();
	}
	
	public MeatEater(int health, int hunger, int speed, int damage, int reproductionRate, int x, int y) {
		this.health = health;
		this.hunger = hunger;
		this.speed = speed;
		this.damage = damage;
		this.reproductionRate = reproductionRate;
		this.x = x;
		this.y = y;
		
	}
	
	public void update() {
		getHungry();
		if(isHungry()) {
			cowToEat = findClosestFood();
			huntFood();
		}
	}
	
	public void huntFood() {
		
		PlantEater cow = food.get(cowToEat);
		
		if(cow.getX() < x) {
			if((getX() - cow.getX()) < speed) {
				setX(x - (getX() - cow.getX()));
			}else
			setX(x - speed);
		}
		if(cow.getX() > x) {
			if((cow.getX() - getX()) < speed) {
				setX(x + (cow.getX() - getX()));
			}else
			setX(x + speed);
		}
		if(cow.getY() < y) {
			if((getY() - cow.getY()) < speed) {
				setY(y - (getY() - cow.getY()));
			}else
			setY(y - speed);
		}
		if(cow.getY() > y) {
			if((cow.getY() - getY()) < speed) {
				setY(y + (cow.getY() - getY()));
			}else
			setY(y + speed);
		}
		
	}
	
	public void getHungry() {
		//add hunger each tick
		hunger = hunger + 5;
	}
	
	public boolean isHungry() {
		if(hunger > 75)
			hungry = true;
		return hungry;
	}
	
	public int findClosestFood() {
		int closestCow = -1;
		
		for(int i = 0; i < food.size(); i++) {
			PlantEater cow = food.get(i);
			int x, y, distance;
			x = cow.getX();
			y = cow.getY();
			distance = (int) Math.sqrt((x * x) + (y * y));
			
			if(closestCow == -1) {
				closestCow = distance;
			}
			if(closestCow > distance) {
				closestCow = distance;
			}
		}
		
		return closestCow;
	}

}
