package school.faang;

public class Pig3Thread extends PigThread {
    private static final int MIN_BUILDING_TIME = 3000;
    private static final int MAX_BUILDING_TIME = 4000;

    public Pig3Thread() {
        super("Naf-Naf", "bricks", MIN_BUILDING_TIME, MAX_BUILDING_TIME);
    }
}
