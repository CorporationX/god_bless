package faang.school.godbless;

public class Angel extends Creature {
    public Angel() {
        super("Angel", 1, 50, 25, 10, 1, 750);
    }

    @Override
    public int getDamage() {
        return getAttack() * getSpeed();
    }
}
