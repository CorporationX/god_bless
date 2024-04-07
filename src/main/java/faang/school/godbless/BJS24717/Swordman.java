package faang.school.godbless.BJS24717;

public class Swordman extends Creature {
    public Swordman() {
        super("Swordman", 1, 2, 5, 5, 1);
    }

    @Override
    public int getDamage() {
        return getQuantity() * getAttack();
    }
}
