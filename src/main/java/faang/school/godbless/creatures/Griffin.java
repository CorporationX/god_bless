package faang.school.godbless.creatures;

public class Griffin extends Creature {
    public Griffin(String name) {
        super(name, 17, 10, 15, 6, 30);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
