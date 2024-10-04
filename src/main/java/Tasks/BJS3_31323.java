package Tasks;

public class BJS3_31323
{
	public void run()
	{
		Warrior warrior = new Warrior("Грек-Хак");
		Archer archer = new Archer("Джелу");
		
		warrior.attack(archer);
		archer.attack(warrior);
	}
}

interface Defensible {
	String getName();
	void takeDamage(int damage);
}

abstract class Character implements Defensible {
	protected String name;
	protected int strength;
	protected int agility;
	private int intellect;
	private int health;
	
	private static final int DEFAULT_HEALTH = 100;
	
	public Character(String name, int strength, int agility, int intellect) {
		this.name = name;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.health = DEFAULT_HEALTH;
	}
	
	public Character(String name) {
		this.name = name;
		this.health = DEFAULT_HEALTH;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void attack(Defensible defensible);
	
	public void takeDamage(int damage) {
		this.health -= damage;
		System.out.println(this.name + " получил " + damage + " урона. Оставшееся здоровье: " + this.health);
	}
	
	protected void showAttackInformation(String enemyName, int damage)
	{
		System.out.println(String.format("%s атакует %s нанося урон : %s",this.name, enemyName, damage));
	}
}

class Warrior extends Character {
	public Warrior(String name) {
		super(name, 10, 5, 3);
	}
	
	@Override
	public void attack(Defensible defensible) {
		showAttackInformation(defensible.getName(), this.strength);
		defensible.takeDamage(this.agility);
	}
}

class Archer extends Character {
	public Archer(String name) {
		super(name, 3, 11, 5);
	}
	
	@Override
	public void attack(Defensible defensible) {
		showAttackInformation(defensible.getName(), this.agility);
		defensible.takeDamage(this.agility);
	}
}