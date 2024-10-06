package school.faang.HeroesOfMightandMagic.Creature;

public class Swordman extends Creature {
    private static final int INITIAL_LEVEL = 3;
    private static final int ATTACK = 10;
    private static final int PROTECTION = 6;
    private static final int SPEED = 5;

    public Swordman(String name) {
        super(name, INITIAL_LEVEL, ATTACK, PROTECTION, SPEED);
    }
}