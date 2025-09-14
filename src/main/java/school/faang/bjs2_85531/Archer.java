package school.faang.bjs2_85531;


import static school.faang.bjs2_85531.HeroCharacter.ARCHER_AGILITY;
import static school.faang.bjs2_85531.HeroCharacter.ARCHER_INTELLIGENCE;
import static school.faang.bjs2_85531.HeroCharacter.ARCHER_STRENGTH;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_AGILITY, ARCHER_STRENGTH, ARCHER_INTELLIGENCE);
    }

    @Override
    public int getHeroAttackDamage() {
        return getAgility();
    }

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
    }
}
