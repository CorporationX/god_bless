package faang.school.godbless.BJS24717;

public class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 1, 10, 5, 15, 1);
    }

    @Override
    public int getDamage() {
        return getQuantity() * getAttack();
    }
}
