package school.faang.bjs2_81166;

public class KnightRider implements Fighter {
    private final int power;

    public KnightRider(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
