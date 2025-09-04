package school.faang.bjs2_85543;

public class Archer extends Character {
    private static final int ARCHER_STRENGTH_BY_DEFAULT = 3;
    private static final int ARCHER_AGILITY_BY_DEFAULT = 10;
    private static final int ARCHER_INTELLIGENCE_BY_DEFAULT = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH_BY_DEFAULT, ARCHER_AGILITY_BY_DEFAULT, ARCHER_INTELLIGENCE_BY_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        super.getHeroAttackDamage(opponent, this.getAgility());
    }
}
