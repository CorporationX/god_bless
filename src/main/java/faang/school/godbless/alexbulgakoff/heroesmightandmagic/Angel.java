package faang.school.godbless.alexbulgakoff.heroesmightandmagic;

/**
 * @author Alexander Bulgakov
 */

public class Angel extends Creature {
    public Angel(String name) {
        super(name, 2, 6, 5, 6, 5);
    }

    @Override
    public int getDamage() {
        return attack + speed;
    }
}