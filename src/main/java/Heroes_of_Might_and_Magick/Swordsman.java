package Heroes_of_Might_and_Magick;

public class Swordsman extends Creature {
    public Swordsman(String name, int level, int attack, int protection, int speed, int amount) {
        super(name, level, attack, protection, speed, amount);
    }

    @Override
    public int getDamage(Creature creature) {
        return creature.getAttack();
    }
}
