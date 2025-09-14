package school.faang.bjs2_85531;

import static school.faang.bjs2_85531.HeroCharacter.WARRIOR_STRENGTH;
import static school.faang.bjs2_85531.HeroCharacter.WARRIOR_AGILITY;
import static school.faang.bjs2_85531.HeroCharacter.WARRIOR_INTELLIGENCE;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public int getHeroAttackDamage() {
        return getStrength();
    }

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
    }
}
