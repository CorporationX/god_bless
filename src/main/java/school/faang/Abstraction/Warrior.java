package school.faang.Abstraction;

public class Warrior extends Character {

    private static final int POWER_WARRIOR = 3;
    private static final int DEXTERITY_WARRIOR = 10;
    private static final int INTELLECT_WARRIOR = 5;

    public Warrior(String name) {
        super(name, POWER_WARRIOR, DEXTERITY_WARRIOR, INTELLECT_WARRIOR);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHp(this.getPower());
    }
}
