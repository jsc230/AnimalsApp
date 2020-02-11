
public class PlantEater extends Animal{

	public PlantEater() {
		super();
	}
	
	public PlantEater(int health, int hunger, int speed, int damage, int reproductionRate, int x, int y) {
		this.health = health;
		this.hunger = hunger;
		this.speed = speed;
		this.damage = damage;
		this.reproductionRate = reproductionRate;
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		setX(x + speed);
	}
	
	public void update() {
		move();
	}
}
