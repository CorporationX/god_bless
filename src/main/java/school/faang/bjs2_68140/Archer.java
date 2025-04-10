package school.faang.bjs2_68140;

import static school.faang.bjs2_68140.GameProperties.AGILITY_ARCHER;
import static school.faang.bjs2_68140.GameProperties.INTELLIGENCE_ARCHER;
import static school.faang.bjs2_68140.GameProperties.STRENGTH_ARCHER;

public class Archer extends Character {
    public Archer(String name) {
        super(name, STRENGTH_ARCHER, AGILITY_ARCHER, INTELLIGENCE_ARCHER);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth()
                - calculateMaxDamage(opponent, this.getAgility()));
    }
}
