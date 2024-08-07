package faang.school.godbless;

public class Swordman extends Creature {
    public Swordman() {
        super("Swordman", 1, 6, 10, 3, 10);
    }

    @Override
    public int getDamage() {
        return getAttack() * getSpeed();
    }
}
