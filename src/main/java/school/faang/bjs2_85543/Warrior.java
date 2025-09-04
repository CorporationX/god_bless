package school.faang.bjs2_85543;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH_BY_DEFAULT = 10;
    private static final int WARRIOR_AGILITY_BY_DEFAULT = 5;
    private static final int WARRIOR_INTELLIGENCE_BY_DEFAULT = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH_BY_DEFAULT, WARRIOR_AGILITY_BY_DEFAULT, WARRIOR_INTELLIGENCE_BY_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        super.getHeroAttackDamage(opponent, this.getStrength());
    }
}
