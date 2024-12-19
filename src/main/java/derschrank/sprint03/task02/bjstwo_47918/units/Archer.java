package derschrank.sprint03.task02.bjstwo_47918.units;

public class Archer extends Unit {
    private static final String DEFAULT_TYPE_OF_HERO = "Archer";
    private static final int DEFAULT_POWER = 25;


    public Archer() {
        this(DEFAULT_POWER);
    }

    public Archer(int power) {
        super(DEFAULT_TYPE_OF_HERO, DEFAULT_POWER);
    }
}
