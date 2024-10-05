package school.faang;

public abstract class Character {

    protected String name;
    protected int strength;
    protected int ability ;
    protected int intellect;
    protected int health = 100;

    public void setName(String name) {
        this.name = name;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int ability, int intellect) {
        this.strength = strength;
        this.ability = ability;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAbility() {
        return ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHealth() {
        return health;
    }

    public String getString() {
        return name + ", " + strength + ", " + ability + ", " + intellect + ", " + health;
    }
}
