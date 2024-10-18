package school.faang.multithreadingarmy;

public class Archer extends Unit {
    private static final int POWER_DEFAULT = 25;

    public Archer() {
        this(POWER_DEFAULT);
    }

    public Archer(int power) {
        super(power);
    }
}
