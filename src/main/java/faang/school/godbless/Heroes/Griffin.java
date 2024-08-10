package faang.school.godbless.Heroes;

public class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 3, 8, 8, 6);
    }

    @Override
    public int getDamage() {
        return (int) (getAttack() * 2.5);
    }
}
