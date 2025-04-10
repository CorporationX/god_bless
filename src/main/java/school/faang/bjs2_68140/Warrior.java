package school.faang.bjs2_68140;

import static school.faang.bjs2_68140.GameProperties.AGILITY_WARRIOR;
import static school.faang.bjs2_68140.GameProperties.INTELLIGENCE_WARRIOR;
import static school.faang.bjs2_68140.GameProperties.STRENGTH_WARRIOR;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, STRENGTH_WARRIOR, AGILITY_WARRIOR, INTELLIGENCE_WARRIOR);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - calculateMaxDamage(opponent, this.getStrength()));
    }
}
