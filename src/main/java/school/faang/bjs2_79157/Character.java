package school.faang.bjs2_79157;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_STARTER_SCORE = 5;

    private final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = DEFAULT_HP;

    public Character(String name) {
        this.name = name;
        this.strength = this.agility = this.intelligence = DEFAULT_STARTER_SCORE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.health = Math.max(0, health - damage);
        System.out.println(this.getName() + " takes " + damage + " damage. Remaining HP: " + this.health + "❤️");
    }
}
