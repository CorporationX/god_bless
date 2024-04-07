package faang.school.godbless.BJS24717;

public class Angel extends Creature {
    public Angel() {
        super("Angel", 1, 12, 8, 10, 1);
    }

    @Override
    public int getDamage() {
        return getQuantity() * getAttack();
    }
}
