package faang.school.godbless.BJS24717;

public class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 1, 3, 3, 3, 1);
    }

    @Override
    public int getDamage() {
        return getQuantity() * getAttack();
    }
}
