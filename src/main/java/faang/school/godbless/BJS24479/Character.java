package faang.school.godbless.BJS24479;

import lombok.Data;

@Data
abstract class Character {

    private final static int INITIAL_HEALTH = 100;

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = INITIAL_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character targetCharacter);
}
