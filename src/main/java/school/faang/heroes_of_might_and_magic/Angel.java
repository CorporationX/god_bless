package school.faang.heroes_of_might_and_magic;

public class Angel extends Creature {

    public Angel(String name) {
        super(name, 99, 450, 999, 999);
    }

    @Override
    public int getDamage() {
        return 0;
    }
}
