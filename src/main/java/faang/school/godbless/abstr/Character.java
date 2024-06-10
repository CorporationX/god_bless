package faang.school.godbless.abstr;

public abstract class Character {
    private String name;
    private int power;
    private int health = 100;
    private int agility;
    private int intellect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int agility, int intellect) {
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }
    public abstract void attack(Character target);
}
