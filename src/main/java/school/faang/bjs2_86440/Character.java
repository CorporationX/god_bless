package school.faang.bjs2_86440;

import lombok.Getter;

@Getter
public abstract class Character {
    private final int strength;
    private final int agility;
    private final int intelligence;

    private String name;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = CharacterConstants.BASIC_VALUES_CHARACTERISTICS;
        this.agility = CharacterConstants.BASIC_VALUES_CHARACTERISTICS;
        this.intelligence = CharacterConstants.BASIC_VALUES_CHARACTERISTICS;
        this.health = CharacterConstants.DEFAULT_HEALTH;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = CharacterConstants.DEFAULT_HEALTH;
    }

    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public abstract void attack(Character opponent);
}