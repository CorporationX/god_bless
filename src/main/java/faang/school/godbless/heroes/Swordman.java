package faang.school.godbless.heroes;

public class Swordman extends Creature {
    private static final double ATTACK = 14;
    private static final double PROTECTION = 3;
    private static final double SPEED = 2;

    public Swordman(String name, double level) {
        super(name, level, ATTACK, PROTECTION, SPEED);
    }

    @Override
    public double getDamage() {
        return (level + 0.3 * speed) * attack;
    }
}
