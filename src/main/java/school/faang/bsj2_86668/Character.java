package school.faang.bsj2_86668;

import lombok.Data;

@Data
public abstract class Character {
    private static final int DEFAULT_HEALTH_VALUE = 100;
    private static final int DEFAULT_COMMON_VALUE = 5;

    String name;
    int strength;
    int agility;
    int intelligence;
    int health = DEFAULT_HEALTH_VALUE;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this(name, DEFAULT_COMMON_VALUE, DEFAULT_COMMON_VALUE, DEFAULT_COMMON_VALUE);
    }

    public abstract void attack(Character opponent);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        } else {
            throw new IllegalArgumentException("Здоровье не может быть меньше 0");
        }
    }
}


