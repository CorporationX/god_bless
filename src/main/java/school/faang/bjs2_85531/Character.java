package school.faang.bjs2_85531;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    public static final int STRENGTH = 5;
    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 5;
    public static final int HELTH = 100;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    protected int health = HELTH;

    public Character(String name) {
        this(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public abstract int getHeroAttackDamage();

    public boolean isAlive() {
        return health > 0;
    }
}
