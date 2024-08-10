package faang.school.godbless.heroes_of_might_and_magic;

public class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 1, 1, 2, 3);
    }

    @Override
    public int getDamage() {
        return (int) (Math.random() * 10);
    }
}
