package school.faang.heroes_of_might_and_magic;

public class Swordman extends Creature {

    public Swordman(String name) {
        super(name, 6, 100, 35, 75);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
