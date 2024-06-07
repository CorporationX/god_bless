package faang.school.godbless.creatures;

public class Angel extends Creature {
    public Angel(String name) {
        super(name, 18, 8, 20, 3, 80);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
