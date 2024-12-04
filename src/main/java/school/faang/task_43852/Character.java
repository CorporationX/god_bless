package school.faang.task_43852;

public abstract class Character {
    private final String name;
    private int strength;
    private int dexterity;
    private int intellect;
    private int health;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHealth() {
        return health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int strength, int dexterity, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = 100;
    }

    protected abstract void attack(Character other);
}
