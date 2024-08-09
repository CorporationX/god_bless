package faang.school.godbless.bjs2_18624;

public class Archer extends Character {
    private static final int DEFAULT_POWER = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_POWER, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(dexterity);
    }
}
