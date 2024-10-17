package school.faang.multithreadingarmy;

public class Swordsman extends Unit {
    private static final int POWER_DEFAULT = 40;

    public Swordsman() {
        this(POWER_DEFAULT);
    }

    public Swordsman(int power) {
        super(power);
    }
}
