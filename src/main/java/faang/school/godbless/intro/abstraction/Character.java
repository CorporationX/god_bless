package faang.school.godbless.intro.abstraction;

import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class Character {
    private final String name;
    private final int force;
    private final int agility;
    private final int intellect;
    private int health = 100;

    public Character(@NonNull String name, int force, int agility, int intellect) {
        validateParameters(force);
        validateParameters(agility);
        validateParameters(intellect);

        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public void takeDamage(int damage) {
        if(health > 0) {
            health -= damage;
        }
    }

    private void validateParameters(int parameter){
        if (parameter < 0){
            throw new IllegalArgumentException("Parameter cannot be negative");
        }
    }
}
