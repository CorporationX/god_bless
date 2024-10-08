package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Angel extends Creature {
    private final static String ANGEL_NAME = "Angel";

    public Angel(int level, int attack, int defence, int speed) {
        super(ANGEL_NAME, level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        // у ангела лапки
        return 0;
    }
}
