package faang.school.godbless.hashmap.heroes;

public class Angel extends Creature{
    @Override
    public int getDamage() {
        return 0;
    }

    public Angel(String name, int level, int attack, int protection, int speed, int quantity) {
        super("Angel", 5, 75, 40, 10, 7);
    }
}
