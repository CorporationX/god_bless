package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Archer extends Character {
    private static final int DEFAULT_ARCHER_STRENGTH = 3;
    private static final int DEFAULT_ARCHER_AGILITY = 10;
    private static final int DEFAULT_ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_ARCHER_STRENGTH, DEFAULT_ARCHER_AGILITY, DEFAULT_ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (canAttack(this.getHealth())) {
            opponent.setHealth(opponent.getHealth() - this.getAgility());
            equateToZeroIfNegative(opponent);
        }
    }
}
