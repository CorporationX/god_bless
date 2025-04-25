package school.faang.bjs269209;

public class Archer extends Character {
    public static final int BASE_STRENGTH_VALUE = 3;
    public static final int BASE_AGILITY_VALUE = 10;

    public Archer(String name) {
        super(name, BASE_STRENGTH_VALUE, BASE_AGILITY_VALUE, BASE_STAT_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.agility);
    }
}
