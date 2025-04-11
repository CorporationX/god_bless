package school.faang.bjs2_68213;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    protected Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public boolean isDie() {
        return health == 0;
    }
}
