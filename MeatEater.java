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
		int xMove;
		int yMove;
		double direction;
		
		direction = directionToCow(cow);
	
		xMove = (int)(Math.cos(direction) * speed);
		yMove = (int)(Math.sin(direction) * speed);
		
		if(getDistance(cow) < speed) {
			if(cow.getX() < x) {
				setX(x - (getX() - cow.getX()));
			}
			if(cow.getX() > x) {
				setX(x + (cow.getX() - getX()));
			}
			if(cow.getY() < y) {
				setY(y - (getY() - cow.getY()));
			}
			if(cow.getY() > y) {
				setY(y + (cow.getY() - getY()));
			}
		}else {		
			setX(x + xMove);
			setY(y + yMove);
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
		int x = Math.abs(cow.getX() - getX());
		int y = Math.abs(cow.getY() - getY());
		
		return (int) Math.sqrt((x * x) + (y * y));
	}
	
	private double directionToCow(PlantEater cow) {
		double direction;
		int x;
		int y;
		
		x = getX() - cow.getX();
		y = getY() - cow.getY();
		
		if(x == 0 && y > 0) {
			direction = Math.toRadians(90);
		}
		else if(x == 0 && y < 0) {
			direction = Math.toRadians(270);
		}
		else if(y == 0 && x < 0) {
			direction = Math.toRadians(180);
		}
		else {
			direction = Math.atan(y/x);
		}
		
		return direction;
	}

}
