package abstraction;

public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intel;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intel) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intel = intel;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", dexterity=" + dexterity +
                ", intel=" + intel +
                ", health=" + health +
                '}';
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public abstract void attack(Character character);
}