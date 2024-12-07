package school.faang.task_43825;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;

    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this(name);
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("Invalid name: %s", name));
        }
        this.name = name;
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
