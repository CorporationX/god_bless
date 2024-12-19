package derschrank.sprint03.task02.bjstwo_47918.units;

public class Swordsman extends Unit {
    private static final String DEFAULT_TYPE_OF_HERO = "Swordsman";
    private static final int DEFAULT_POWER = 75;

    public Swordsman() {
        this(DEFAULT_POWER);
    }

    public Swordsman(int power) {
        super(DEFAULT_TYPE_OF_HERO, DEFAULT_POWER);
    }
}
