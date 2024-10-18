package school.faang.multithreadingarmy;

public class Mage extends Unit {
    private static final int POWER_DEFAULT = 50;

    public Mage() {
        this(POWER_DEFAULT);
    }

    public Mage(int power) {
        super(power);
    }
}
