package heroes_of_might_and_magic;

public class Swordman extends Creature {
    private static final int DAMAGE_COEFFICIENT = 4;

    public Swordman(String name, int level, int attack, int protection, int speed) {
        super(name, level, attack, protection, speed);
    }

    @Override
    public int getDamage() {
        return this.getLevel() * DAMAGE_COEFFICIENT;
    }
}
