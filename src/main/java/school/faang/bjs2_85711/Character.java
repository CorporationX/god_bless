package school.faang.bjs2_85711;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    public static final int INDICATOR_HEALTH = 100;
    public static final int BASIC_CHARACTERISTIC = 5;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this(name, BASIC_CHARACTERISTIC, BASIC_CHARACTERISTIC, BASIC_CHARACTERISTIC);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = INDICATOR_HEALTH;
    }

    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public abstract void attack(Character opponent);

    @Override
    public String toString() {
        return String.format("%s [Сила: %d, Ловкость: %d, Интеллект: %d, Здоровье: %d]",
                name, strength, agility, intelligence, health);
    }
}
