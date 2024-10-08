package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Griffin extends Creature {
    private final static String GRIFFIN_NAME = "Griffin";

    public Griffin(int level, int attack, int defence, int speed) {
        super(GRIFFIN_NAME, level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        return level * attack - speed;
    }
}
