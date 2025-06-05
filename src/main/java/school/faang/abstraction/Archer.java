package school.faang.abstraction;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.decreaseHealth(this.strength);
    }

    @Override
    public String toString() {
        return "Archer(name = " + name + ")";
    }
}
