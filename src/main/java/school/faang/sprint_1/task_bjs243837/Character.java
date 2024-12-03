package school.faang.sprint_1.task_bjs243837;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    protected Character(String name) {
        validateName(name);
        this.name = name;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this(name);
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException(this.getName() + " is dead.");
        }
        this.health = health;
    }

    protected abstract void attack(Character opponent);

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name must be not empty");
        }
    }
}
