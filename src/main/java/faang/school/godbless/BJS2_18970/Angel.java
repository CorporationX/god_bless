package faang.school.godbless.BJS2_18970;

public class Angel extends Creature {
    public Angel(String name) {
        super(name, 8, 9, 12, 10, 10);
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
