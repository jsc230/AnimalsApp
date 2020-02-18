
public class PlantEater extends Animal{
	
	AnimalsApp animals;
	private boolean lionClose = false;
	
	public PlantEater() {
		super();
	}
	
	public PlantEater(int health, int hunger, int speed, int damage, int reproductionRate, int x, int y, AnimalsApp animals) {
		this.health = health;
		this.hunger = hunger;
		this.speed = speed;
		this.damage = damage;
		this.reproductionRate = reproductionRate;
		this.x = x;
		this.y = y;
		this.animals = animals;
		
	}
	
	public void move() {
		int xMove;
		int yMove;
		int walkSpeed = speed / 2;
		double randDirection = Math.toRadians(Math.random() * 360);
		
		if(lionClose == false) {
			xMove = (int) (Math.cos(randDirection) * walkSpeed);
			yMove = (int) (Math.sin(randDirection) * walkSpeed);
		
			setX(x + xMove);
			setY(y + yMove);
		}	
		
		if(lionClose == true) {
			xMove = (int)(Math.cos(directionToLion()) * speed);
			yMove = (int)(Math.sin(directionToLion()) * speed);
			
			setX(x + xMove);
			setY(y + yMove);
		}
	}
	
	public void update() {
		isLionClose();
		move();
	}
	
	public boolean isLionClose() {
		int distance;
		int x = Math.abs(getX() - animals.getLion().getX());
		int y = Math.abs(getY() - animals.getLion().getX());
		
		distance = (int) Math.sqrt((x * x) + (y * y));
		
		if(distance < 35) {
			lionClose = true;
		}else {
			lionClose = false;
		}
		
		return lionClose;
	}
	
	public double directionToLion() {
		double directionToLion;
		int x;
		int y;
		
		x = getX() - animals.getLion().getX();
		y = getY() - animals.getLion().getY();
		
		if(x == 0 && y > 0) {
			directionToLion = Math.toRadians(90);
		}
		else if(x == 0 && y < 0) {
			directionToLion = Math.toRadians(270);
		}
		else if(y == 0 && x < 0) {
			directionToLion = Math.toRadians(180);
		}
		else
			directionToLion = Math.atan(y / x);
		
		return directionToLion;
	}
}
