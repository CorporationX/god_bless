package faang.school.godbless.creatures;

public class Pikeman extends Creature {
    public Pikeman(String name) {
        super(name, 7, 3, 7, 6, 40);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
