package faang.school.godbless.hashmap.heroes;

public class Swordman extends Creature{

    @Override
    public int getDamage() {
        return 0;
    }

    public Swordman(String name, int level, int attack, int protection, int speed, int quantity) {
        super("Swordman", 4, 16, 24, 6, 88);
    }
}
