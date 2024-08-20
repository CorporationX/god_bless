package faang.school.godbless.BJS2_23412;

public class Mage implements Unit {

    private final int power;

    public Mage(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
