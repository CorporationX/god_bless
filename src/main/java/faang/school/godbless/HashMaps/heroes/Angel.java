package faang.school.godbless.HashMaps.heroes;

public class Angel extends Creature {
    private static final double ATTACK = 13;
    private static final double PROTECTION = 5;
    private static final double SPEED = 4;

    public Angel(String name, double level) {
        super(name, level, ATTACK, PROTECTION, SPEED);
    }

    @Override
    public double getDamage() {
        return (level + 0.4 * speed) * attack;
    }
}
