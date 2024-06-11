package faang.school.godbless.HashMaps.heroes;

public class Griffin extends Creature {
    private static final double ATTACK = 14;
    private static final double PROTECTION = 5;
    private static final double SPEED = 2;

    public Griffin(String name, double level) {
        super(name, level, ATTACK, PROTECTION, SPEED);
    }

    @Override
    public double getDamage() {
        return (level + 0.5 * speed) * attack;
    }
}
