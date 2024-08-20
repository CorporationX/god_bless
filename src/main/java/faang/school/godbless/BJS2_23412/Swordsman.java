package faang.school.godbless.BJS2_23412;

public class Swordsman implements Unit {

    private final int power;

    public Swordsman(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
