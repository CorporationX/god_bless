package school.faang.bjs2_85543;

import static school.faang.bjs2_85543.HeroesCharacteristics.WARRIOR_AGILITY_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.WARRIOR_INTELLIGENCE_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.WARRIOR_STRENGTH_BY_DEFAULT;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH_BY_DEFAULT, WARRIOR_AGILITY_BY_DEFAULT, WARRIOR_INTELLIGENCE_BY_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        super.reduceHealth(opponent, this.getStrength());
    }
}
