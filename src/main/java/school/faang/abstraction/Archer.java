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
        super(name);
        strength = DEFAULT_ARCHER_STRENGTH;
        agility = DEFAULT_ARCHER_AGILITY;
        intelligence = DEFAULT_ARCHER_INTELLIGENCE;
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        if (canAttack(this.health)) {
            opponent.setHealth(opponent.getHealth() - this.agility);
            equateToZeroIfNegative(opponent);
        }
    }
}
