package school.faang.bjs269209;

public class Warrior extends Character {
    public static final int BASE_STRENGTH_VALUE = 10;
    public static final int BASE_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name, BASE_STRENGTH_VALUE, BASE_STAT_VALUE, BASE_INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.strength);
    }
}
