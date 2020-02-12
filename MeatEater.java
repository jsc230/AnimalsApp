import java.util.ArrayList;

public class MeatEater extends Animal {
	
	private int cowToEat;
	AnimalsApp animals;
	
	public MeatEater() {
		super();
	}
	
	public MeatEater(int health, int hunger, int speed, int damage, int reproductionRate, int x, int y, AnimalsApp animals) {
		this.health = health;
		this.hunger = hunger;
		this.speed = speed;
		this.damage = damage;
		this.reproductionRate = reproductionRate;
		this.x = x;
		this.y = y;
		this.animals = animals;
	}
	
	public void update() {
		getHungry();
		if(isHungry()) {
			cowToEat = findClosestFood();
			huntFood();
		}
	}
	
	public void huntFood() {
		
		PlantEater cow = animals.getFoodItems().get(cowToEat);
		
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
		
		for(int i = 0; i < animals.getFoodItems().size(); i++) {
			PlantEater cow = animals.getFoodItems().get(i);
			int x, y, distance;


			
			if(closestCow == -1) {
				closestCow = i;
			}
			if(getDistance(animals.getFoodItems().get(closestCow)) > getDistance(animals.getFoodItems().get(i))) {
				closestCow = i;
			}
		}
		
		return closestCow;
	}

	private int getDistance(PlantEater cow) {
		int x = cow.getX();
		int y = cow.getY();
		return (int) Math.sqrt((x * x) + (y * y));
	}

}
