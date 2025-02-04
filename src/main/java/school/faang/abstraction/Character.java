package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_VALUE = 5;
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = DEFAULT_HEALTH;

    protected Character(String name) {
        this(name, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        if (name == null) {
            throw new NullPointerException("Значение имени пользователя не может быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void checkHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
    }
}