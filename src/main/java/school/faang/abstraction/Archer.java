package school.faang.abstraction;

public class Archer extends Character {

    public static final int STRENGTH_FOR_ARCHER = 3;
    public static final int AGILITY_FOR_ARCHER = 10;
    public static final int INTELLIGENCE_FOR_ARCHER = 5;

    public Archer(String name) {
        super(name);
        setStrength(STRENGTH_FOR_ARCHER);
        setAgility(AGILITY_FOR_ARCHER);
        setIntelligence(INTELLIGENCE_FOR_ARCHER);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        opponent.deathHero();
    }
}