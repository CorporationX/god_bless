package faang.school.godbless.sword_magic;

public class Angel extends Creature{
    public static final int ATTACK_BOOST_PER_LEVEL = 1;
    public static final int ARMOR_BOOST_PER_LEVEL = 6;
    public static final int SPEED_BOOST_PER_LEVEL = 2;
    public static final int ANGEL_QUANTITY = 1;

    public Angel(int level) {
        super("Angel", level);
        this.attack = level * ATTACK_BOOST_PER_LEVEL;
        this.armor = level * ARMOR_BOOST_PER_LEVEL;
        this.speed = level * SPEED_BOOST_PER_LEVEL;
        this.quantity = ANGEL_QUANTITY;
    }
}
