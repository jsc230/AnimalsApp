
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
		setX(x + speed);
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
		
		if(distance < 15) {
			lionClose = true;
		}else {
			lionClose = false;
		}
		
		return lionClose;
	}
}
