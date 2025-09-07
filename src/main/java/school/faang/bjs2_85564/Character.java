package school.faang.bjs2_85564;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    public static final int STRENGTH = 5;
    public static final int AQILITY = 5;
    public static final int INTELLIGENCE = 5;
    public static final int HEALTH = 100;

    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = HEALTH;
    private String name;

    public Character(String name) {
        this(name, STRENGTH, AQILITY, INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected void takeDamage(int damage) {
        if (isAlive()) {
            this.health = Math.max(this.health -= damage, 0);
        } else {
            System.out.println("Враг уже побеждён!");
        }
    }

    public abstract void attack(Character opponent);

    private boolean isAlive() {
        return health > 0;
    }
}
