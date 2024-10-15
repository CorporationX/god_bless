package school.faang.abstractionabstraction;

public abstract class Character {

    public static final int DEFAULT_HEALTH = 100;

    String name;
    int strength;
    int dexterity;
    int intelligence;
    int health = DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
}
