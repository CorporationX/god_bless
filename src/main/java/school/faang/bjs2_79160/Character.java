package school.faang.bjs2_79160;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected boolean isMakeAttack(int health, int damage) {
        return health >= damage;
    }

    protected abstract void attack(Character opponent);
}
