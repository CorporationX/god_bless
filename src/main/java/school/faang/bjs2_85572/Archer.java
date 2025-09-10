package school.faang.bjs2_85572;

import static school.faang.bjs2_85572.DefaultParameters.AGILITY_ARCHER;
import static school.faang.bjs2_85572.DefaultParameters.INTELLIGENCE_ARCHER;
import static school.faang.bjs2_85572.DefaultParameters.STRENGTH_ARCHER;

public class Archer extends Character {
    public Archer(String name) {
        super(name, STRENGTH_ARCHER, AGILITY_ARCHER, INTELLIGENCE_ARCHER);
    }

    @Override
    public void attack(Character opponent) {
        if (!isDead(opponent)) {
            opponent.setHp(opponent.getHealth() - this.getAgility());
        }
        printStatusHp(opponent);
    }
}