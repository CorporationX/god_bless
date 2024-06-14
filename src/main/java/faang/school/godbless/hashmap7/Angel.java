package faang.school.godbless.hashmap7;

public class Angel extends Creature {
    public static final String ANGEL_NAME = "Angel";
    public static final int ANGEL_LVL = 1;
    public static final int ANGEL_DAMAGE = 1;
    public static final int ANGEL_DEFENSE = 0;
    public static final int ANGEL_SPEED = 1;
    public static final int ANGEL_QUANTITY = 10;


    public Angel() {
        super(ANGEL_NAME, ANGEL_LVL, ANGEL_DAMAGE, ANGEL_DEFENSE, ANGEL_SPEED, ANGEL_QUANTITY);
    }
}
