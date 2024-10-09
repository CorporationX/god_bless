package school.faang.heroes_of_might_and_magic;

public class Griffin extends Creature {

    public Griffin(String name) {
        super(name, 8, 110, 40, 90);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
