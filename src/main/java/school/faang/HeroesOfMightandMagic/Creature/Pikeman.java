package school.faang.HeroesOfMightandMagic.Creature;

public class Pikeman extends Creature {
    private static final int INITIAL_LEVEL = 1;
    private static final int ATTACK = 5;
    private static final int PROTECTION = 3;
    private static final int SPEED = 4;

    public Pikeman(String name) {
        super(name, INITIAL_LEVEL, ATTACK, PROTECTION, SPEED);
    }

}
