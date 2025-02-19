package school.faang;

public class Pig2Thread extends PigThread {
    private static final int MIN_BUILDING_TIME = 2000;
    private static final int MAX_BUILDING_TIME = 3000;

    public Pig2Thread() {
        super("Nuf-Nuf", "sticks", MIN_BUILDING_TIME, MAX_BUILDING_TIME);
    }
}
