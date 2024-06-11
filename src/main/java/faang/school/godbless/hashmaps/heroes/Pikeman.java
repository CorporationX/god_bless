package faang.school.godbless.hashmaps.heroes;

public class Pikeman extends Creature {
    private static final double ATTACK = 15;
    private static final double PROTECTION = 3;
    private static final double SPEED = 4;

    public Pikeman(String name, double level) {
        super(name, level, ATTACK, PROTECTION, SPEED);
    }

    @Override
    public double getDamage() {
        return (level + 0.1 * speed) * attack;
    }
}
