package school.faang.bjs2_79157;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_STARTER_SCORE = 5;

    private final String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int hp = DEFAULT_HP;

    public Character(String name) {
        this.name = name;
        this.strength = this.dexterity = this.intelligence = DEFAULT_STARTER_SCORE;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.hp = Math.max(0, hp - damage);
        System.out.println(this.getName() + " takes " + damage + " damage. Remaining HP: " + this.hp + "❤️");
    }
}
