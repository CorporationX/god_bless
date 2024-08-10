package faang.school.godbless.Heroes;

public class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 1, 4, 5, 4);
    }

    @Override
    public int getDamage() {
        return getAttack() * 2;
    }
}
