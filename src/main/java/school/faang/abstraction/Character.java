package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_VALUE = 5;
    protected final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    protected Character(String name) {
        validateName(name);

        this.name = name;
        this.health = DEFAULT_HEALTH;
        this.agility = DEFAULT_VALUE;
        this.strength = DEFAULT_VALUE;
        this.intelligence = DEFAULT_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        validateName(name);

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected void validateName(String name) {
        if (name == null) {
            throw new NullPointerException("Значение имени пользователя не может быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public abstract void attack(Character opponent);

    public void checkHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
