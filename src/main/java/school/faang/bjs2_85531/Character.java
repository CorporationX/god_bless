package school.faang.bjs2_85531;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    protected int health;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    public abstract int getHeroAttackDamage();

    public boolean isAlive() {
        return health > 0;
    }
}
