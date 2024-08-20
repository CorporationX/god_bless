package faang.school.godbless.BJS2_23412;

public class Archer implements Unit {
    private final int power;

    public Archer(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
