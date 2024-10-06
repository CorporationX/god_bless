package school.faang.heroes_of_might_and_magic;

public class Pikeman extends Creature{
    public Pikeman(String name) {
        super(name, 5, 90, 120, 40);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
