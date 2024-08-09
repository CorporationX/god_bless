package faang.school.godbless.bjs2_18624;

public class Warrior extends Character {
    private static final int DEFAULT_POWER = 10;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_POWER, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(power);
    }
}
