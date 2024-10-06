package school.faang.BJS2_28997;

public abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
    int health;

    public Character(String name, int strength, int agility, int intelligence, int health) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
    }

    public abstract Character attack(Character character);
}
