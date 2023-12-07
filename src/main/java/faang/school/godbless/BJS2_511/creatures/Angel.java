package faang.school.godbless.BJS2_511.creatures;

public class Angel extends Creature {
    public static final String ANGEL_DEFAULT_NAME = "Angel";
    public static final int ANGEL_DEFAULT_LEVEL = 1;
    public static final int ANGEL_DEFAULT_DAMAGE = 1;
    public static final int ANGEL_DEFAULT_DEFENSE = 1;
    public static final int ANGEL_DEFAULT_SPEED = 1;
    public static final int ANGEL_DEFAULT_QUANTITY = 1;

    public Angel(int quantity) {
        super(ANGEL_DEFAULT_NAME, ANGEL_DEFAULT_LEVEL, ANGEL_DEFAULT_DAMAGE, ANGEL_DEFAULT_DEFENSE, ANGEL_DEFAULT_SPEED, quantity);
    }

    @Override
    public int getDamage() {
        return this.getAttack() + getDefence();
    }
}
