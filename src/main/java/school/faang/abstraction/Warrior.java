package school.faang.abstraction;

public class Warrior extends Character {

    public static final int STRENGTH_FOR_WARRIOR = 10;
    public static final int AGILITY_FOR_WARRIOR = 5;
    public static final int INTELLIGENCE_FOR_WARRIOR = 3;

    public Warrior(String name) {
        super(name);
        setStrength(STRENGTH_FOR_WARRIOR);
        setAgility(AGILITY_FOR_WARRIOR);
        setIntelligence(INTELLIGENCE_FOR_WARRIOR);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        opponent.deathHero();
    }
}