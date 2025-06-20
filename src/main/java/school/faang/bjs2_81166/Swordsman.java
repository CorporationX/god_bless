package school.faang.bjs2_81166;

public class Swordsman implements Fighter {
    private final int power;

    public Swordsman(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
