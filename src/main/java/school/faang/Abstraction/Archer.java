package school.faang.Abstraction;

public class Archer extends Character {
    private static final int POWER_ARCHER = 3;
    private static final int DEXTERITY_ARCHER = 10;
    private static final int INTELLECT_ARCHER = 5;

    public Archer(String name) {
        super(name, POWER_ARCHER, DEXTERITY_ARCHER, INTELLECT_ARCHER);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHp(this.getDexterity());
    }
}
