package faang.school.godbless.BJS2_18631;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }
}
