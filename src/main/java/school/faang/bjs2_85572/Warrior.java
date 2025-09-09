package school.faang.bjs2_85572;

import static school.faang.bjs2_85572.DefaultParameters.AGILITY_WARRIOR;
import static school.faang.bjs2_85572.DefaultParameters.INTELLIGENCE_WARRIOR;
import static school.faang.bjs2_85572.DefaultParameters.STRENGTH_WARRIOR;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, STRENGTH_WARRIOR, AGILITY_WARRIOR, INTELLIGENCE_WARRIOR);
    }

    @Override
    public void attack(Character opponent) {
        if (isDead(opponent)) {
            printStatusHp(opponent);
            opponent.setHealth(opponent.getHealth() - this.getStrength());
        } else {
            opponent.setHealth(0);
            printStatusHp(opponent);
        }
    }
}