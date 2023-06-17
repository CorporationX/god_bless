package faang.school.godbless.abstraction;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(@NonNull String name) {
        this.name = name;
    }

    public Character(@NonNull String name, int strength, int agility, int intellect) {
        checkNegativeValues(strength);
        checkNegativeValues(agility);
        checkNegativeValues(intellect);

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public boolean isAlive() {
        return this.health > 0;
    }

    protected void inflictDamage(int damage) {
        this.health -= damage;
        if (health <= 0) {
            System.out.println(name + "is dead");
            health = 0;
        }
    }

    private void checkNegativeValues(int parameter) {
        if (parameter < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
    }
}
