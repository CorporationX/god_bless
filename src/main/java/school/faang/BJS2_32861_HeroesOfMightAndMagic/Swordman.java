package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Swordman extends Creature {
    public Swordman(int level, int attack, int defence, int speed) {
        super("Swordman", level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        return level * attack - (speed + defence) / 2;
    }
}
