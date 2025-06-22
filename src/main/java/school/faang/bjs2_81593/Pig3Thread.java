package school.faang.bjs2_81593;

public class Pig3Thread extends PigThread {
    private static final int CONSTRUCTION_TIME = 4000;

    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }

    @Override
    public void run() {
        buildHouse(CONSTRUCTION_TIME);
    }
}
