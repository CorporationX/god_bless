package faang.school.godbless.heroes_of_might_and_magic;

public class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 1, 2, 1, 2);
    }

    @Override
    public int getDamage() {
        return (int) (Math.random() * 10);
    }
}
