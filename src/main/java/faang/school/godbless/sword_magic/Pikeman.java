package faang.school.godbless.sword_magic;

public class Pikeman extends Creature{
    public static final int ATTACK_BOOST_PER_LEVEL = 3;
    public static final int ARMOR_BOOST_PER_LEVEL = 3;
    public static final int SPEED_BOOST_PER_LEVEL = 1;
    public static final int PIKEMAN_QUANTITY = 5;

    public Pikeman(int level) {
        super("Pikeman", level);
        this.attack = level * ATTACK_BOOST_PER_LEVEL;
        this.armor = level * ARMOR_BOOST_PER_LEVEL;
        this.speed = level * SPEED_BOOST_PER_LEVEL;
        this.quantity = PIKEMAN_QUANTITY;
    }
}
