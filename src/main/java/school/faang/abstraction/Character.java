package school.faang.abstraction;

public abstract class Character {
    private String name;
    private String strength;
    private Integer agility;
    private Integer intellect;
    private int health;

    public abstract void attack();

    public Character(String name, String strength, Integer agility, Integer intellect, int health) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.health = health;
    }
}
