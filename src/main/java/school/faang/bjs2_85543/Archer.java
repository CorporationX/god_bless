package school.faang.bjs2_85543;

import static school.faang.bjs2_85543.HeroesCharacteristics.ARCHER_AGILITY_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.ARCHER_INTELLIGENCE_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.ARCHER_STRENGTH_BY_DEFAULT;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_STRENGTH_BY_DEFAULT, ARCHER_AGILITY_BY_DEFAULT, ARCHER_INTELLIGENCE_BY_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        super.reduceHealth(opponent, this.getAgility());
    }
}
