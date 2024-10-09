package school.faang.HeroesOfMightandMagic.Creature;

public class Angel extends Creature {
    private static final int INITIAL_LEVEL = 4;
    private static final int ATTACK = 15;
    private static final int PROTECTION = 8;
    private static final int SPEED = 7;

    public Angel(String name) {
        super(name, INITIAL_LEVEL, ATTACK, PROTECTION, SPEED);
    }
}
