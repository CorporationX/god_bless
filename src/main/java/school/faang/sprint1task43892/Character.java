package school.faang.sprint1task43892;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Character {
    private static final int MAX_HEALTH = 100;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private int health = MAX_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);

    public void receiveDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным");
        }

        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }
}