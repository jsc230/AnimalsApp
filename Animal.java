
public class Animal {
	
	protected int health;
	protected int hunger;
	protected int speed;
	protected int damage;
	protected int reproductionRate;
	protected int x;
	protected int y;
	boolean alive = true;
	boolean hungry = false;
	
	public Animal() {}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setReproductionRate(int reproductionRate) {
		this.reproductionRate = reproductionRate;
	}
	
	public int getReproductionRate() {
		return reproductionRate;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
