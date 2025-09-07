package school.faang.bjs2_85700;

import lombok.Getter;
import lombok.ToString;

@Getter
public abstract class Character {

    public static final int MIN_ABILITY_VALUE = 1;
    public static final int MAX_ABILITY_VALUE = 10;
    private static final int CHARACTER_DEFAULT_STRENGTH = 5;
    private static final int CHARACTER_DEFAULT_AGILITY = 5;
    private static final int CHARACTER_DEFAULT_INTELLIGENCE = 5;
    private static final int DEFAULT_HEALTH = 100;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = DEFAULT_HEALTH;

    public Character(String name) {
        validateName(name);

        this.name = name;
        this.strength = CHARACTER_DEFAULT_STRENGTH;
        this.agility = CHARACTER_DEFAULT_AGILITY;
        this.intelligence = CHARACTER_DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        validateName(name);
        validateAbilities(strength, agility, intelligence);

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        if (isAlive()) {
            this.health = Math.max(this.health - damage, 0);
        } else {
            System.out.println("Противник уже повержен!");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым.");
        }
    }

    private void validateAbilities(int strength, int agility, int intelligence) {
        if (!(MIN_ABILITY_VALUE <= strength && strength <= MAX_ABILITY_VALUE)
                || !(MIN_ABILITY_VALUE <= agility && agility <= MAX_ABILITY_VALUE)
                || !(MIN_ABILITY_VALUE <= intelligence && intelligence <= MAX_ABILITY_VALUE)) {
            throw new IllegalArgumentException("Способности должны быть от 1 до 10.");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
