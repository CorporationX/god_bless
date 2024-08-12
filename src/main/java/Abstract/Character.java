package Abstract;

public abstract class Character {
    protected String name;
    protected int power;
    protected int  agility;
    protected int intelligent;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int  agility, int intelligent) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligent = intelligent;
    }

    public abstract void attack(Character character);

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
