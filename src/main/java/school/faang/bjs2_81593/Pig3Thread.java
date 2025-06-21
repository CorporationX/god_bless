package school.faang.bjs2_81593;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }

    @Override
    public void run() {
        buildHouse(4000);
    }
}
