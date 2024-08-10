package faang.school.godbless.BJS2_18970;

public class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 7, 8, 5, 9, 10);
    }

    @Override
    public int getDamage() {
        return 5;
    }
}