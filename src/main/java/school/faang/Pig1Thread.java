package school.faang;

public class Pig1Thread extends PigThread {
    private static final int MIN_BUILDING_TIME = 1000;
    private static final int MAX_BUILDING_TIME = 2000;

    public Pig1Thread() {
        super("Nif-Nif", "straw", MIN_BUILDING_TIME, MAX_BUILDING_TIME);
    }
}
