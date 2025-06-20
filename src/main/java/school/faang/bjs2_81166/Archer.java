package school.faang.bjs2_81166;

public class Archer implements Fighter {
    private final int power;

    public Archer(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
