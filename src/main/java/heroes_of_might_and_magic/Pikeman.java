package heroes_of_might_and_magic;

public class Pikeman extends Creature {
    public Pikeman(String name, int level, int attack, int protection, int speed) {
        super(name, level, attack, protection, speed);
    }

    @Override
    public int getDamage() {
        return this.getLevel() * 2;
    }
}
