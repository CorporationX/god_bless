package school.faang.abstraction;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Archer extends Character {

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.decreaseHealth(this.agility);
    }

    @Override
    public String toString() {
        return "Archer(name = " + name + ")";
    }
}
