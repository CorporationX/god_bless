package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Pikeman extends Creature{
    public Pikeman(int level, int attack, int defence, int speed) {
        super("Pikeman", level, attack, defence, speed);
    }

    @Override
    public int getDamage() {
        return level * attack - defence;
    }
}
