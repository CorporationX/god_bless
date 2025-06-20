package school.faang.bjs2_81166;

public class Mage implements Fighter {
    private final int power;

    public Mage(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
