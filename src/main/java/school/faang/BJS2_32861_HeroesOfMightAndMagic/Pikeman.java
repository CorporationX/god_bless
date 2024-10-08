package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Pikeman extends Creature{
    private final static String PIKEMAN_NAME = "Pikeman";

    public Pikeman(int level, int attack, int defence, int speed) {
        super(PIKEMAN_NAME, level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        return level * attack - defence;
    }
}
