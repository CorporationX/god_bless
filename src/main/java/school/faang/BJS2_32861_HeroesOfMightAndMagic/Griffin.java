package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Griffin extends Creature {
    public Griffin(int level, int attack, int defence, int speed) {
        super("Griffin", level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        return level * attack - speed;
    }
}
