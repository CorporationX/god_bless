package school.faang.bjs2_85564;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = Constants.DEFAULT_HEALTH;
    private final String name;

    public Character(String name) {
        this(name, Constants.CHARACTER_DEFAULT_STRENGTH, Constants.CHARACTER_DEFAULT_AGILITY, Constants.CHARACTER_DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected void takeDamage(int damage) {
        if (!isAlive()) {
            System.out.println("Враг уже побеждён!");
            return;
        }
        this.health = Math.max(this.health -= damage, 0);
    }

    public abstract void attack(Character opponent);

    public boolean isAlive() {
        return health > 0;
    }
}
