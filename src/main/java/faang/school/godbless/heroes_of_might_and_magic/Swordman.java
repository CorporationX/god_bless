package faang.school.godbless.heroes_of_might_and_magic;

public class Swordman extends Creature {
    public Swordman() {
        super("Swordman", 1, 1, 3, 1);
    }

    @Override
    public int getDamage() {
        return (int) (Math.random() * 10);
    }
}
