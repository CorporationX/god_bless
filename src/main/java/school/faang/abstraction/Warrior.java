package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Warrior extends Character {
    private static final int DEFAULT_WARRIOR_STRENGTH = 10;
    private static final int DEFAULT_WARRIOR_AGILITY = 5;
    private static final int DEFAULT_WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        super.setStrength(DEFAULT_WARRIOR_STRENGTH);
        super.setAgility(DEFAULT_WARRIOR_AGILITY);
        super.setIntelligence(DEFAULT_WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (canAttack(this.getHealth())) {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
            equateToZeroIfNegative(opponent);
        }
    }
}
