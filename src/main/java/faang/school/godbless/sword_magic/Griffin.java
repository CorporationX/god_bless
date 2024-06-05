package faang.school.godbless.sword_magic;

public class Griffin extends Creature{
    public static final int ATTACK_BOOST_PER_LEVEL = 1;
    public static final int ARMOR_BOOST_PER_LEVEL = 3;
    public static final int SPEED_BOOST_PER_LEVEL = 3;
    public static final int GRIFFIN_QUANTITY = 1;

    public Griffin(int level) {
        super("Griffin", level);
        this.attack = level * ATTACK_BOOST_PER_LEVEL;
        this.armor = level * ARMOR_BOOST_PER_LEVEL;
        this.speed = level * SPEED_BOOST_PER_LEVEL;
        this.quantity = GRIFFIN_QUANTITY;
    }
}
