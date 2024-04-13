package faang.school.godbless.hashmap.heroes;

public class Pikeman extends Creature{
    @Override
    public int getDamage() {
        return 0;
    }

    public Pikeman(String name, int level, int attack, int protection, int speed, int quantity) {
        super("Pikeman", 2, 12, 8, 5, 400);
    }
}
