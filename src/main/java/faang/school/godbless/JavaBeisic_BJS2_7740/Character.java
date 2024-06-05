package faang.school.godbless.JavaBeisic_BJS2_7740;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    // Абстрактный метод attack
    public abstract void attack(Character target);

    // Геттеры и сеттеры для полей (если потребуется)
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
