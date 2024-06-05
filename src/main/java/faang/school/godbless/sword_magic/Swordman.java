package faang.school.godbless.sword_magic;

public class Swordman extends Creature{
    public static final int ATTACK_BOOST_PER_LEVEL = 2;
    public static final int ARMOR_BOOST_PER_LEVEL = 2;
    public static final int SPEED_BOOST_PER_LEVEL = 2;

    public Swordman(int level, int quantity) {
        super("Swordman", level, quantity);
        this.attack = level * ATTACK_BOOST_PER_LEVEL;
        this.armor = level * ARMOR_BOOST_PER_LEVEL;
        this.speed = level * SPEED_BOOST_PER_LEVEL;
    }
}
