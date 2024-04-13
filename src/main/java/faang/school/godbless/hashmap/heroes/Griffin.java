package faang.school.godbless.hashmap.heroes;

public class Griffin extends Creature{

    @Override
    public int getDamage() {
        return 0;
    }

    public Griffin(String name, int level, int attack, int protection, int speed, int quantity) {
        super("Griffin", 4, 38, 40, 12, 42);
    }
}
