package derschrank.sprint03.task02.bjstwo_47918.units;

public class Mage extends Unit {
    private static final String DEFAULT_TYPE_OF_HERO = "Mage";
    private static final int DEFAULT_POWER = 50;

    public Mage() {
        this(DEFAULT_POWER);
    }

    public Mage(int power) {
        super(DEFAULT_TYPE_OF_HERO, DEFAULT_POWER);
    }
}
