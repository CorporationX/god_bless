package faang.school.godbless.heroes_of_might_and_magic;

public class Angel extends Creature {
    public Angel() {
        super("Angel", 1, 1, 1, 3);
    }

    @Override
    public int getDamage() {
        return (int) (Math.random() * 10);
    }
}
