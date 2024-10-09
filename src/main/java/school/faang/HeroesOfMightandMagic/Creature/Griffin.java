package school.faang.HeroesOfMightandMagic.Creature;

public class Griffin extends Creature {
    private static final int INITIAL_LEVEL = 2;
    private static final int ATTACK = 7;
    private static final int PROTECTION = 5;
    private static final int SPEED = 6;

    public Griffin(String name) {
        super(name, INITIAL_LEVEL, ATTACK, PROTECTION, SPEED);
    }

}
