package faang.school.godbless.BJS2_511.creatures;

public class Angel extends Creature {
    public static final String ANGEL_DEFAULT_NAME = "Angel";
    public static final int ANGEL_DEFAULT_LEVEL = 10;
    public static final int ANGEL_DEFAULT_ATTACK = 10;
    public static final int ANGEL_DEFAULT_DEFENSE = 10;
    public static final int ANGEL_DEFAULT_SPEED = 10;

    public Angel(int quantity) {
        super(ANGEL_DEFAULT_NAME, ANGEL_DEFAULT_LEVEL, ANGEL_DEFAULT_ATTACK, ANGEL_DEFAULT_DEFENSE, ANGEL_DEFAULT_SPEED, quantity);
    }
    public Angel(int quantity, String name) {
        super(name, ANGEL_DEFAULT_LEVEL, ANGEL_DEFAULT_ATTACK, ANGEL_DEFAULT_DEFENSE, ANGEL_DEFAULT_SPEED, quantity);
    }

    @Override
    public int getDamage() {
        return super.getDamage() + getDefence();
    }
}
