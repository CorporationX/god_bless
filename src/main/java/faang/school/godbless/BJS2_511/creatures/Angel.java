package faang.school.godbless.BJS2_511.creatures;

public class Angel extends Creature{
    public Angel(int quantity) {
        super("Angel", 1, 1, 1, 1, quantity);
    }

    @Override
    public int getDamage () {
        return this.getAttack() + getDefence();
    }
}
