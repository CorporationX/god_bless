package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Angel extends Creature {
    public Angel(int level, int attack, int defence, int speed) {
        super("Angel", level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        // у ангела лапки
        return 0;
    }
}
