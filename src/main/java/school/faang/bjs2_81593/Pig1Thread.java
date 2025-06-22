package school.faang.bjs2_81593;

public class Pig1Thread extends PigThread {
    private static final int CONSTRUCTION_TIME = 2000;

    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        buildHouse(CONSTRUCTION_TIME);
    }
}
