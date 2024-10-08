package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Swordman extends Creature {
    private final static String SWORDMAN_NAME = "Swordman";

    public Swordman(int level, int attack, int defence, int speed) {
        super(SWORDMAN_NAME, level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        return level * attack - (speed + defence) / 2;
    }
}
