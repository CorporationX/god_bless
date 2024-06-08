package faang.school.godbless.creatures;

public class Swordman extends Creature {
    public Swordman(String name) {
        super(name, 27, 16, 8, 13, 60);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
